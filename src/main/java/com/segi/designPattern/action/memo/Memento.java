package com.segi.designPattern.action.memo;

/**
 * @author chenzx
 * @date 2019-11-26 上午 10:08
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
