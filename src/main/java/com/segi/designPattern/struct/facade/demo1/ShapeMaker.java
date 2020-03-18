package com.segi.designPattern.struct.facade.demo1;

/**
 * @author chenzx
 * @date 2019-07-18 上午 10:26
 */
public class ShapeMaker {
    private Shape circle;
    private Shape square;
    private Shape rectanble;

    public ShapeMaker() {
        this.circle = new Circle();
        this.square = new Square();
        this.rectanble = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawRectangle() {
        rectanble.draw();
    }

}
