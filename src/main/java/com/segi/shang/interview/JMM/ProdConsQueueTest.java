package com.segi.shang.interview.JMM;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzx
 * @date 2020-03-05 下午 5:05
 */
public class ProdConsQueueTest {

    public static void main(String[] args) {
        ProdCons prodCons = new ProdCons(new ArrayBlockingQueue<>(5));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t启动");
            System.out.println();
            prodCons.prod();
        }, "prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t启动");
            System.out.println();
            try {
                prodCons.cons();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();
        
        try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
        prodCons.stop();
        System.out.println(Thread.currentThread().getName() + "\t线程叫停");
    }
}

class ProdCons {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public ProdCons(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("传入了阻塞队列：" + blockingQueue.getClass().getName());
    }

    public void prod() {
        int data;
        while (flag) {
            data = atomicInteger.incrementAndGet();
            boolean offer = blockingQueue.offer(data + "");
            if (offer) {
                System.out.println(Thread.currentThread().getName() + "\t生产成功，数据：" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t生产失败，数据：" + data);
            }
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println(Thread.currentThread().getName() + "\t生产者停止生产");
    }

    public void cons() throws InterruptedException {
        while (flag) {
            String poll = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (StringUtils.isNotBlank(poll)) {
                System.out.println(Thread.currentThread().getName() + "\t消费失败，数据：" + poll);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t消费成功，数据：" + poll);
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t消费者停止消费");

    }

    public void stop() {
        flag = false;
    }
}
