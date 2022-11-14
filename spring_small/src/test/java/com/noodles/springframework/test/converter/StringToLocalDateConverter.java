package com.noodles.springframework.test.converter;

import com.noodles.springframework.core.convert.converter.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description: StringToLocalDateConverter
 * @author: liuxian
 * @date: 2022-11-14 23:06
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    private final DateTimeFormatter DATE_TIME_FORMATTER;

    public StringToLocalDateConverter(String pattern) {
        this.DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, DATE_TIME_FORMATTER);
    }
}
