package com.segi.designPattern.create.prototype.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenzx
 * @date 2018-11-26 下午 7:26
 */
public class ShapeCached {
    public static Map<String, Shape> cachedShapes = new HashMap<>();

    public void loadShapes() {
        Circle circle = new Circle();
        circle.setId("1");
        cachedShapes.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        cachedShapes.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId("3");
        cachedShapes.put(square.getId(), square);
    }

    public Shape getShape(String shapeId) throws CloneNotSupportedException {
        return cachedShapes.get(shapeId).clone();
    }
}
