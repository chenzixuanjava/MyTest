package com.segi.designPattern.action.observer.demo1;

/**
 * @author chenzx
 * @date 2018-11-23 下午 7:53
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("HexObserver get the state:" + Integer.toHexString(this.subject.getState()));
    }
}
