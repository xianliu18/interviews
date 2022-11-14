package com.noodles.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import com.noodles.springframework.stereotype.Component;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description: ClassPathScanningCandidateComponentProvider
 * @author: liuxian
 * @date: 2022-11-13 22:24
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
