package com.segi.designPattern.action.observer.demo1;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-11-23 下午 5:29
 */
public class Subject {
    private List<Observer> observers = Lists.newArrayList();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(o -> o.update());
    }
}
