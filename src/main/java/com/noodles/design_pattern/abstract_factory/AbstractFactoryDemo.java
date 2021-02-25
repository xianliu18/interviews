package com.noodles.design_pattern.abstract_factory;

/**
 * @ClassName AbstractFactoryDemo
 * @Description 示例
 * @Author noodles
 * @Date 2021/2/25 17:48
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        red.fill();
    }

}
