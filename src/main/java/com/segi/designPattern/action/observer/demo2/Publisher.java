package com.segi.designPattern.action.observer.demo2;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-12-10 下午 6:31
 */
public class Publisher {
    private List<Listener> listeners = Lists.newArrayList();
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
        notifyObservers();
    }

    public void attachListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void notifyObservers() {
        listeners.forEach(Listener::update);
    }
}
