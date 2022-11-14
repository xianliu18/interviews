package com.noodles.springframework.beans.factory.config;

import com.noodles.springframework.beans.factory.HierarchicalBeanFactory;
import com.noodles.springframework.core.convert.ConversionService;
import com.noodles.springframework.utils.StringValueResolver;
import com.sun.istack.internal.Nullable;

/**
 * @description: 可配置 Bean 工厂接口
 * @author: liuxian
 * @date: 2022-11-11 18:21
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    @Nullable
    ConversionService getConversionService();
}
