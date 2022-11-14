package com.noodles.springframework.core.convert.converter;

/**
 * @description: 类型转换注册接口
 * @author: liuxian
 * @date: 2022-11-14 22:01
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverter(GenericConverter converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

}
