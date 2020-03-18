package com.segi.javase.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzx
 * @date 2019-06-11 下午 3:46
 */
public class AtomicCounter {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }
}
