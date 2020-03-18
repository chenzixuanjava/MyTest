package com.segi.designPattern.action.template.demo1;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:36
 */
public abstract class Game {
    abstract void initialize();

    abstract void start();

    abstract void end();

    public final void play() {
        initialize();
        start();
        end();
    }
}
