package com.segi.designPattern.struct.decorator;

/**
 * @author chenzx
 * @date 2019-11-22 下午 5:37
 */
public abstract class ShapeDecorator {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
