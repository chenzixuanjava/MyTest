package com.segi.javase.concurrent.procons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author chenzx
 * @date 2019-06-12 上午 9:39
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> drop = new SynchronousQueue<String>();
        new Thread(new Producter(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
