package com.segi.javase.concurrent.javaConcurrencyPractice;

import java.util.Vector;

/**
 * @author chenzx
 * @date 2019-11-22 下午 6:28
 */
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean pubIfAbsent(E e) {
        boolean absent = !contains(e);
        if (absent) {
            add(e);
        }
        return absent;
    }
}
