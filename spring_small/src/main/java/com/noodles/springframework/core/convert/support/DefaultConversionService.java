package com.noodles.springframework.core.convert.support;

import com.noodles.springframework.core.convert.converter.ConverterRegistry;

/**
 * @description: 默认转换服务
 * @author: liuxian
 * @date: 2022-11-14 22:02
 */
public class DefaultConversionService extends GenericConversionService {

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
