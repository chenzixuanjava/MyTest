package com.segi.shang.interview.JMM;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzx
 * @date 2020-02-25 上午 8:59
 */
public class VolatileTest {
    volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        num = 60;
    }

    public void addOne() {
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
//        volatileSee();
        volatileNotAtomic();
    }

    /**
     * volatile不保证原子性
     * 办法：
     * ①AtomicInteger
     * ②同步锁
     */
    private static void volatileNotAtomic() {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 1; i <= 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 1000; j++) {
                        volatileTest.addOne();
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("sum:" + volatileTest.atomicInteger);
    }

    /**
     * volatile保证可见性
     */
    private static void volatileSee() {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " come in");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileTest.addTo60();
                System.out.println(Thread.currentThread().getName() + " updated, value:" + volatileTest.num);
            }
        }, "T1").start();

        while (volatileTest.num == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "线程获取到num:" + volatileTest.num);
    }
}


