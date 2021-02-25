package com.noodles.design_pattern.abstract_factory.impl;

import com.noodles.design_pattern.abstract_factory.Shape;

/**
 * @ClassName Rectangle
 * @Description 实现类
 * 参考链接： https://www.runoob.com/design-pattern/abstract-factory-pattern.html
 * @Author noodles
 * @Date 2021/2/25 17:00
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
