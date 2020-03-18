package com.segi.designPattern.action.observer.demo2;

/**
 * @author chenzx
 * @date 2018-12-10 下午 6:30
 */
public class Listener2 extends Listener {

    public Listener2(Publisher publisher) {
        super(publisher);
    }

    @Override
    void update() {
        System.out.println("Listener2:" + this.getPublisher().getEvent());
    }
}
