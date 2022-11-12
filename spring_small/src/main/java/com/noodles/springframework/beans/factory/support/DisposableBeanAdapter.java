package com.noodles.springframework.beans.factory.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.DisposableBean;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Method;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: Bean 销毁适配器
 * @author: liuxian
 * @date: 2022-11-12 18:14
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1, 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean)bean).destroy();
        }

        // 2, XML 配置 destroy-method
        if (StringUtils.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named [ " + destroyMethodName + " ] on bean with name [ " + beanName + " ]");
            }
            destroyMethod.invoke(bean);
        }
    }
}
