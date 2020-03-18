package com.segi.javase.concurrent;

import java.util.Random;

/**
 * @author chenzx
 * @date 2019-06-06 下午 2:41
 */
public class Producter implements Runnable {

    private Drop drop;

    public Producter(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        String msg[] = {"chen", "zi", "xuan", "niubi"};
        for (int i = 0; i < msg.length; i++) {
            drop.put(msg[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("DONE");
    }
}
