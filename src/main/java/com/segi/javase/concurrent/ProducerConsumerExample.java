package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-06 下午 2:48
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producter(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
