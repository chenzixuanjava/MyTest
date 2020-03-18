package com.segi.designPattern.create.prototype.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 4:55
 */
public class Square extends Shape{

    public Square() {
        this.type = "Square";
    }
    @Override
    void draw() {
        System.out.println("draw Square");
    }
}
