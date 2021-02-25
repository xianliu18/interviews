package com.noodles.design_pattern.abstract_factory.impl;

import com.noodles.design_pattern.abstract_factory.Shape;

/**
 * @ClassName Circle
 * @Description 实现类
 * @Author noodles
 * @Date 2021/2/25 17:33
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
