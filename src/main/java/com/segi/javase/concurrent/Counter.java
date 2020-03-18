package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-04 下午 3:36
 */
public class Counter{
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int value() {
        return counter;
    }
}
