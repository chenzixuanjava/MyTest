package com.segi.shang.interview.JMM;
import java.util.concurrent.ExecutorService;
import	java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chenzx
 * @date 2020-03-06 下午 5:38
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t启动");
            }
        };
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 10; i++) {
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                Future<?> submit = executorService.submit(runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
