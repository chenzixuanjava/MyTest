package com.segi.designPattern.create.factory.demo1;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chenzx
 * @date 2018-12-17 下午 4:05
 */
public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (StringUtils.isEmpty(shapeType)) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
