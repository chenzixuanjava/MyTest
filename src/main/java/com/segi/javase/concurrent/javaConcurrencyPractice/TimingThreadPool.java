package com.segi.javase.concurrent.javaConcurrencyPractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenzx
 * @date 2019-11-28 下午 3:09
 */
public class TimingThreadPool extends ThreadPoolExecutor {

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final Logger logger = LoggerFactory.getLogger(TimingThreadPool.class);
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.info("t:{},r:{}", t, r);
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long taskTime = System.nanoTime() - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            logger.info("r:{},t:{},taskTime:{}", r, t, taskTime);
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            logger.info("avg time:{}", String.valueOf(totalTime.get() / numTasks.get()));
        } finally {
            super.terminated();
        }
    }

    public static void main(String[] args) {
        TimingThreadPool exec = new TimingThreadPool(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable> ());
        exec.submit(new DemoRunnable());
        exec.submit(new DemoRunnable());
        exec.submit(new DemoRunnable());
        exec.shutdown();
    }

}

class DemoRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("线程：" + Thread.currentThread().getName() + " run");
    }
}

