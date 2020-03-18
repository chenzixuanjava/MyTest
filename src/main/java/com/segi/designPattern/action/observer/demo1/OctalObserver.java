package com.segi.designPattern.action.observer.demo1;

/**
 * @author chenzx
 * @date 2018-11-23 下午 7:53
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver get the state:" + Integer.toOctalString(this.subject.getState()));
    }
}
