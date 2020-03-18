package com.segi.designPattern.action.observer.demo2;

/**
 * @author chenzx
 * @date 2018-12-10 下午 6:30
 */
public class Listener1 extends Listener {

    public Listener1(Publisher publisher) {
        super(publisher);
    }

    @Override
    void update() {
        System.out.println("Listener1:" + this.getPublisher().getEvent());
    }
}
