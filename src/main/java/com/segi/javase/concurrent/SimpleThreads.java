package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-04 上午 11:56
 */
public class SimpleThreads {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String importantInfo[] = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        // 中断等待时间
        long patience = 1000 * 6;

        // 如果控制台有输入时间，获取输入台输入的时间.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // 循环直至MessageLoop退出
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // 等待1秒，让MessageLoop完成任务
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // 永久等待
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
