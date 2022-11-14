package com.noodles.springframework.test.converter;

import com.noodles.springframework.beans.factory.FactoryBean;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: ConverterFactoryBean
 * @author: liuxian
 * @date: 2022-11-14 23:04
 */
public class ConvertersFactoryBean implements FactoryBean<Set<?>> {

    @Override
    public Set<?> getObject() throws Exception {
        Set<Object> converters = new HashSet<>();
        StringToLocalDateConverter stringToLocalDateConverter = new StringToLocalDateConverter("yyyy-MM-dd");
        converters.add(stringToLocalDateConverter);
        return converters;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
