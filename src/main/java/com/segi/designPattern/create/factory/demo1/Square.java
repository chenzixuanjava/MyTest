package com.segi.designPattern.create.factory.demo1;

/**
 * @author chenzx
 * @date 2018-12-17 下午 4:04
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println(this.getClass().getSimpleName() + "draw");
    }
}
