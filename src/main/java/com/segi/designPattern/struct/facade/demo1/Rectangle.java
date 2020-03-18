package com.segi.designPattern.struct.facade.demo1;

/**
 * @author chenzx
 * @date 2019-07-18 上午 10:25
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
