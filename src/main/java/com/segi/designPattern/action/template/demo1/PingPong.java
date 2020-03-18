package com.segi.designPattern.action.template.demo1;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:38
 */
public class PingPong extends Game {
    @Override
    void initialize() {
        System.out.println(this.getClass().getSimpleName() + " initialize");
    }

    @Override
    void start() {
        System.out.println(this.getClass().getSimpleName() + " start");
    }

    @Override
    void end() {
        System.out.println(this.getClass().getSimpleName() + " end");
    }
}
