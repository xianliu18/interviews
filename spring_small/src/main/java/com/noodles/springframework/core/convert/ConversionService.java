package com.noodles.springframework.core.convert;

import javax.annotation.Nullable;

/**
 * @description: 类型转换抽象接口
 * @author: liuxian
 * @date: 2022-11-14 22:02
 */
public interface ConversionService {

    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);

}
