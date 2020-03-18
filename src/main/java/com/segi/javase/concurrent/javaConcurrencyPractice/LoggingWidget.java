package com.segi.javase.concurrent.javaConcurrencyPractice;

/**
 * @author chenzx
 * @date 2019-07-01 下午 4:18
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println("LoggingWidget do something");
        super.doSomething();
    }
}
