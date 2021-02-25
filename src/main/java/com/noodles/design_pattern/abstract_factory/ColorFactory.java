package com.noodles.design_pattern.abstract_factory;

import com.noodles.design_pattern.abstract_factory.impl.Blue;
import com.noodles.design_pattern.abstract_factory.impl.Green;
import com.noodles.design_pattern.abstract_factory.impl.Red;

/**
 * @ClassName ColorFactory
 * @Description 工厂类
 * @Author noodles
 * @Date 2021/2/25 17:39
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
