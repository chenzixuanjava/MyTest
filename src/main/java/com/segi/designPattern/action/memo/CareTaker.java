package com.segi.designPattern.action.memo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenzx
 * @date 2019-11-26 上午 10:10
 */
public class CareTaker {

    private List<Memento> mementos = Lists.newArrayList();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}
