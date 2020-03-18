package com.segi.shang.interview.JMM;

import java.util.Currency;

/**
 * @author chenzx
 * @date 2020-03-08 上午 8:57
 */
public class DeadLockTest {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {

            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "\t 持有a");
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "\t 持有b");
                }
            }
        }, "t1").start();

        new Thread(() -> {

            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "\t 持有b");
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "\t 持有a");
                }
            }
        }, "t２").start();

    }
}
