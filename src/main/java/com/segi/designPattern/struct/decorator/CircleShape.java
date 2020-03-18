package com.segi.designPattern.struct.decorator;

/**
 * @author chenzx
 * @date 2019-11-22 下午 5:36
 */
public class CircleShape implements Shape {

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}
