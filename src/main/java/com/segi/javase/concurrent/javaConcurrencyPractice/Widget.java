package com.segi.javase.concurrent.javaConcurrencyPractice;

/**
 * @author chenzx
 * @date 2019-07-01 下午 4:17
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println("Widget do something");
    }
}

