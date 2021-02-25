package com.noodles.design_pattern.abstract_factory;

/**
 * @ClassName AbstractFactory
 * @Description 抽象工厂
 * @Author noodles
 * @Date 2021/2/25 17:36
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
