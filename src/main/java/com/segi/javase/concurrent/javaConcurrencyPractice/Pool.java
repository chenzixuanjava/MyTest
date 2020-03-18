package com.segi.javase.concurrent.javaConcurrencyPractice;
import	java.util.concurrent.Callable;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import	java.util.concurrent.Semaphore;

/**
 * @author chenzx
 * @date 2019-11-23 下午 3:39
 */
public class Pool {
    private static final int MAX_AVAILABLE = 6;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
    private Integer[] ages = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    private boolean[] used = new boolean[MAX_AVAILABLE];

    public Integer getAge() throws InterruptedException {
        available.acquire();
        return getNextAvailableAge();
    }

    private Integer getNextAvailableAge() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                return ages[i];
            }
        }
        return null;
    }

    public void putAge(Integer age) {
        if (markAsUnUsed(age)) {
            available.release();
            System.out.println("input:" + age);
        }
    }

    private boolean markAsUnUsed(Integer age) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (age.equals(ages[i])) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Pool pool = new Pool();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        new Thread().start();
        executor.submit(new GetFromPool(pool));
        executor.execute(new PutIntoPool(pool));
    }
}

class GetFromPool implements Callable<Integer> {

    private final Pool pool;

    public GetFromPool(Pool pool) {
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        for (; ;) {
            System.out.println("get:" + pool.getAge());
        }
    }
}

class PutIntoPool implements Runnable {

    private final Pool pool;

    public PutIntoPool(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        for (; ; ) {
            for (int i = 1; i <= 10; i++) {
                pool.putAge(i);
            }
        }
    }
}