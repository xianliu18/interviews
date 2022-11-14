package com.noodles.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.noodles.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import com.noodles.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.noodles.springframework.stereotype.Component;
import java.util.Set;

/**
 * @description: ClassPathBeanDefinitionScanner
 * @author: liuxian
 * @date: 2022-11-13 22:24
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }

        // 注册处理注解的 BeanPostProcessor(@Autowired, @Value)
        registry.registerBeanDefinition("com.noodles.springframework.context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition((AutowiredAnnotationBeanPostProcessor.class)));
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
