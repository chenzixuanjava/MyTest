package com.segi.designPattern.action.observer.demo1;

/**
 * @author chenzx
 * @date 2018-11-23 下午 5:33
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
