package com.segi.javase.concurrent.javaConcurrencyPractice;
import	java.util.concurrent.Executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author chenzx
 * @date 2019-11-23 下午 2:16
 */
public class Driver2 {
    public static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(5);
        Executor e = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            e.execute(new Worker2(doneSignal, i));
        }
        doneSignal.await();
        System.out.println(sum);
    }
}

class Worker2 implements Runnable {

    private final CountDownLatch doneSignal;
    private final int i;

    public Worker2(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        doWork(i);
        doneSignal.countDown();
    }

    private void doWork(int i) {
        Driver2.sum += i;
    }
}
