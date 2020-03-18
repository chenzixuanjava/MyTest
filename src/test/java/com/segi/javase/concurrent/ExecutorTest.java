package com.segi.javase.concurrent;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chenzx
 * @date 2019-06-03 下午 7:31
 */
public class ExecutorTest {

    @Test
    public void testDirectExecutor() {
        Runnable r = () -> {
            System.out.println("线程：" + Thread.currentThread().getName());
        };
        new DirectExecutor().execute(r);
    }

    @Test
    public void testThreadPerTaskExecutor() {
        Runnable r = () -> {
            System.out.println("线程：" + Thread.currentThread().getName());
        };
        Runnable r2 = () -> {
            System.out.println("线程：" + Thread.currentThread().getName());
        };
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();
        executor.execute(r);
        executor.execute(r2);
    }

    @Test
    public void testInterferecce() {
        Counter counter = new Counter();
        new Thread(() -> {
            counter.increment();
            System.out.println(String.format("%s:%s%n", Thread.currentThread().getName(), counter.value()));
        }).start();
        new Thread(() -> {
            counter.decrement();
            System.out.println(String.format("%s:%s%n", Thread.currentThread().getName(), counter.value()));
        }).start();
    }

    @Test
    public void testMap() {
        Map<String, Object> map = Maps.newHashMap();
        System.out.println(map.get("name"));
    }

    @Test
    public void testThreadLocalRamdom() {
        System.out.println(ThreadLocalRandom.current().nextInt(10, 100));
    }

    @Test
    public void testCounter() throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            counter.increment();
            System.out.println(Thread.currentThread().getName() + "给counter递增1");
        };
        new Thread(r).start();
        Thread.sleep(10);
        System.out.println(counter.value());

    }

    @Test
    public void testAtomicCounter() {
        AtomicCounter atomicCounter = new AtomicCounter();
        Runnable r = () -> {
            atomicCounter.increment();
            System.out.println(Thread.currentThread().getName() + "给counter递增1");
        };
        new Thread(r).start();
        System.out.println(atomicCounter.value());
    }
}


