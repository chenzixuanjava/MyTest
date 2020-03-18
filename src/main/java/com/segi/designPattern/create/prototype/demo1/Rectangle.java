package com.segi.designPattern.create.prototype.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 4:55
 */
public class Rectangle extends Shape{

    public Rectangle() {
        this.type = "Rectangle";
    }
    @Override
    void draw() {
        System.out.println("draw Rectangle");
    }
}
