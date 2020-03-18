package com.segi.designPattern.action.memo;

/**
 * @author chenzx
 * @date 2019-11-26 上午 10:06
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public String getStateFromMemento(Memento memento) {
        return memento.getState();
    }
}
