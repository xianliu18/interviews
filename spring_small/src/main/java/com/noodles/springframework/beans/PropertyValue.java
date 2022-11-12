package com.noodles.springframework.beans;

/**
 * @description: TODO
 * @author: liuxian
 * @date: 2022-11-11 17:27
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
