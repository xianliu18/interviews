package com.noodles.design_pattern.abstract_factory;

/**
 * @ClassName FactoryProducer
 * @Description 工厂生成器
 * @Author noodles
 * @Date 2021/2/25 17:45
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
