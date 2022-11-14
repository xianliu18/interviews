package com.noodles.springframework.core.convert.converter;

/**
 * @description: 类型转换处理接口
 * @author: liuxian
 * @date: 2022-11-14 22:00
 */
public interface Converter<S, T> {

    /** 将 S 类型转换为 T 类型 */
    T convert(S source);

}
