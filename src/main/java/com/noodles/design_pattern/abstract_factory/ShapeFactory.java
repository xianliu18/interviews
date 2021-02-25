package com.noodles.design_pattern.abstract_factory;

import com.noodles.design_pattern.abstract_factory.impl.Circle;
import com.noodles.design_pattern.abstract_factory.impl.Rectangle;
import com.noodles.design_pattern.abstract_factory.impl.Square;

/**
 * @ClassName ShapeFactory
 * @Description ShapeFactory
 * @Author noodles
 * @Date 2021/2/25 17:38
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
