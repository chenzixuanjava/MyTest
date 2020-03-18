package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-04 上午 11:08
 */
public class JoinTestThread {

    private static int count = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + " " + count);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                count++;
                if (20 == count) {
                    try {
                        t1.join();
                        System.out.println(Thread.currentThread().getName()+ "t1.join()");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + count);
            }
        });
        t1.start();
        t2.start();
    }
}
