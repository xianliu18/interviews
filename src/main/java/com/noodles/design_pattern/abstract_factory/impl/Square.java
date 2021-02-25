package com.noodles.design_pattern.abstract_factory.impl;

import com.noodles.design_pattern.abstract_factory.Shape;

/**
 * @ClassName Square
 * @Description 实现类
 * @Author noodles
 * @Date 2021/2/25 17:32
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() medho.");
    }
}
