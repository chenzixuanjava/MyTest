package com.segi.shang.interview.JMM;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzx
 * @date 2020-03-05 上午 9:58
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("b", 2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("c", 2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("d", 2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));

    }
}
