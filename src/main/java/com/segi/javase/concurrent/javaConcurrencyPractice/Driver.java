package com.segi.javase.concurrent.javaConcurrencyPractice;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzx
 * @date 2019-11-23 下午 2:00
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        init();
        startSignal.countDown();
        driverWorking();
        doneSignal.await();
    }

    private static void driverWorking() {
        System.out.println("driver working...");
    }

    private static void init() {
        System.out.println("driver initing...");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            return;
        }
        doWork();
        doneSignal.countDown();
    }

    private void doWork() {
        System.out.println("worker working...");
    }
}
