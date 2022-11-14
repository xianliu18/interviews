package com.noodles.springframework.test.converter;

import com.noodles.springframework.core.convert.converter.Converter;

/**
 * @description: StringToIntegerConverter
 * @author: liuxian
 * @date: 2022-11-14 23:07
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
