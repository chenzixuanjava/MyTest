package com.segi.javase.concurrent.javaConcurrencyPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenzx
 * @date 2019-11-23 上午 9:54
 */
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean pubIfAbsent(E e) {
        boolean absent = !list.contains(e);
        synchronized (list) {
            if (absent) {
                list.add(e);
            }
            return absent;
        }
    }
}
