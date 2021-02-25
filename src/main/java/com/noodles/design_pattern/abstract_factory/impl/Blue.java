package com.noodles.design_pattern.abstract_factory.impl;

import com.noodles.design_pattern.abstract_factory.Color;

/**
 * @ClassName Blue
 * @Description 实现类
 * @Author noodles
 * @Date 2021/2/25 17:35
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
