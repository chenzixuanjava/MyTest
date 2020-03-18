package com.segi.javase.concurrent.procons;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author chenzx
 * @date 2019-06-06 下午 2:41
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> drop;

    public Consumer(BlockingQueue drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (String msg = drop.take(); !"DNOE".equals(msg); msg = drop.take() ) {
                System.out.println(String.format("获取信息:%s%n", msg));
                Thread.sleep(random.nextInt(5000));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
