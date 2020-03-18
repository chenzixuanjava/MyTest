package com.segi.shang.interview.JMM;

import java.util.concurrent.Semaphore;

/**
 * @author chenzx
 * @date 2020-03-05 上午 8:13
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t获取车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "\t离开车位");
                }
            }, "" + i).start();
        }
    }
}
