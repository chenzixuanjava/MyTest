package com.segi.javase.concurrent.javaConcurrencyPractice;
import java.util.concurrent.*;

/**
 * @author chenzx
 * @date 2019-11-28 上午 11:26
 */
public class ThreadDeadLock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    class RendPageTask implements Callable <String> {

        @Override
        public String call() throws Exception {

            return exec.submit(new Callable<String> () {

                @Override
                public String call() throws Exception {
                    return "chenzixuan";
                }
            }).get();
        }
    }

    public String getResult() throws ExecutionException, InterruptedException {
        return exec.submit(new RendPageTask()).get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new ThreadDeadLock().getResult();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor exec1 = (ThreadPoolExecutor) exec;

    }
}