package com.segi.javase.concurrent;

import java.util.Random;

/**
 * @author chenzx
 * @date 2019-06-06 下午 2:41
 */
public class Consumer implements Runnable {

    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String msg = drop.take(); !"DNOE".equals(msg); msg = drop.take() ) {
            System.out.println(String.format("获取信息:%s%n", msg));
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
