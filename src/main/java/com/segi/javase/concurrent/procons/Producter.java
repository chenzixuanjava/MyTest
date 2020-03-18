package com.segi.javase.concurrent.procons;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author chenzx
 * @date 2019-06-06 下午 2:41
 */
public class Producter implements Runnable {

    private BlockingQueue<String> drop;

    public Producter(BlockingQueue drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        String msg[] = {"chen", "zi", "xuan", "niubi"};
        try {
            for (int i = 0; i < msg.length; i++) {
                drop.put(msg[i]);
                Thread.sleep(random.nextInt(5000));
            }
            drop.put("DONE");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
