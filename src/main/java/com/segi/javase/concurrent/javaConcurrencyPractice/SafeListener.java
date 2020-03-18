package com.segi.javase.concurrent.javaConcurrencyPractice;

/**
 * @author chenzx
 * @date 2019-07-02 上午 11:00
 */
public class SafeListener {

    private SafeListener() {
        new Runnable() {
            @Override
            public void run() {
                doSometing();
            }
        };
    }

    public static SafeListener newInstance() {
        return new SafeListener();
    }

    private void doSometing() {
    }
}
