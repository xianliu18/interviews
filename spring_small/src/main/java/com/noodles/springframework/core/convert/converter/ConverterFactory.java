package com.noodles.springframework.core.convert.converter;

/**
 * @description: ConverterFactory
 * @author: liuxian
 * @date: 2022-11-14 22:01
 */
public interface ConverterFactory<S, R> {

    /**
     * Get the converter to convert from S to target type T, where T is also an instance of R.
     */
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);

}
