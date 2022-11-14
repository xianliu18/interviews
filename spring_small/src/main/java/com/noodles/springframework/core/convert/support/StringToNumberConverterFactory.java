package com.noodles.springframework.core.convert.support;

import com.noodles.springframework.core.convert.converter.Converter;
import com.noodles.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.NumberUtils;

/**
 * @description: StringToNumberConverterFactory
 * @author: liuxian
 * @date: 2022-11-14 22:02
 */public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
