package com.segi.shang.interview.JMM;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author chenzx
 * @date 2020-03-05 上午 10:24
 */
public class SynchronousQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String> ();

        new Thread(() -> {
            try {
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t放入1");

                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t放入2");

                queue.put("3");
                System.out.println(Thread.currentThread().getName() + "\t放入3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                queue.take();
                try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

                queue.take();
                try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

                queue.take();
                try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t2").start();
    }
}
