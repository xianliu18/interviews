package com.noodles.design_pattern.abstract_factory.impl;

import com.noodles.design_pattern.abstract_factory.Color;

/**
 * @ClassName Red
 * @Description 红色
 * @Author noodles
 * @Date 2021/2/25 17:34
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
