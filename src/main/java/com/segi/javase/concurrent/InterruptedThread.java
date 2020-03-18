package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-11-21 下午 4:41
 */
public class InterruptedThread {
    public static void main(String[] args){
        try {
            printMsg();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("是否还是被中断：" + Thread.interrupted());
        }

    }

    private static void printMsg() throws InterruptedException {
        String msgs[] = {"chen", "zi", "xuan", "24"};

        for (int i = 0; i < msgs.length; i++) {
            if (i == 2) {
                Thread.currentThread().interrupt();
            }
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
            System.out.println(msgs[i]);
        }
    }
}
