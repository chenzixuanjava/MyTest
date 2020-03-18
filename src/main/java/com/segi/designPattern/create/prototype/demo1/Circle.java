package com.segi.designPattern.create.prototype.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 4:55
 */
public class Circle extends Shape{

    public Circle() {
        this.type = "Cirlce";
    }
    @Override
    void draw() {
        System.out.println("draw Circle");
    }
}
