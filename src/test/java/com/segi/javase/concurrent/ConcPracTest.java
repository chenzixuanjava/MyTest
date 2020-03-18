package com.segi.javase.concurrent;

import com.segi.javase.concurrent.javaConcurrencyPractice.BetterVector;
import com.segi.javase.concurrent.javaConcurrencyPractice.BoundedBuffer;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

/**
 * @author chenzx
 * @date 2019-11-22 下午 6:31
 */
public class ConcPracTest {
    BoundedBuffer boundedBuffer;

    @Before
    public void before() {
        boundedBuffer = new BoundedBuffer();
    }

    @Test
    public void test() {
        BetterVector<Integer> betterVector = new BetterVector<>();
        System.out.println(betterVector.pubIfAbsent(1));
        System.out.println(betterVector.pubIfAbsent(2));
        System.out.println(betterVector.pubIfAbsent(1));
        System.out.println(betterVector);
        System.out.println();

        Vector<Integer> vector = new Vector<>();
        System.out.println(vector.add(1));
        System.out.println(vector.add(2));
        System.out.println(vector.add(1));
        System.out.println(vector);
    }

    @Test
    public void testCondition() throws InterruptedException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        boundedBuffer.put(1);
                        System.out.println("put:" + 1);
                        System.out.println("put后的长度：" + boundedBuffer.getItems().length);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("take:" + boundedBuffer.take());
                        System.out.println("take后的长度：" + boundedBuffer.getItems().length);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Test
    public void testCondition02() throws InterruptedException {
        System.out.println(boundedBuffer.take());
    }



}
