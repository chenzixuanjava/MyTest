package com.segi.javase.concurrent.javaConcurrencyPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chenzx
 * @date 2019-11-23 下午 2:50
 */
public class PreLoader {
    private Long sum = 0L;
    private final FutureTask<Long> future = new FutureTask<Long>(new Callable<Long>() {
        @Override
        public Long call() throws Exception {
            for (long i = 0; i < 100000000L; i++) {
                sum += i;
            }
            return sum;
        }
    });
    private Thread thread = new Thread(future);

    private void start() {
        thread.start();
    }

    private Long get() throws ExecutionException, InterruptedException {
        return future.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PreLoader preLoader = new PreLoader();
        preLoader.start();
        System.out.println("begin get");
        System.out.println(preLoader.get());
        System.out.println("end get");
    }
}
