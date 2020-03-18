package com.segi.javase.concurrent.javaConcurrencyPractice;

import org.springframework.context.event.EventListener;

import javax.servlet.ServletRegistration;

/**
 * @author chenzx
 * @date 2019-07-02 上午 10:51
 */
public class ThisEscape {

    public ThisEscape() {
        new Runnable() {
            @Override
            public void run() {
                doSometing();
            }
        };
    }

    private void doSometing() {
        System.out.println("hello");
    }
}

