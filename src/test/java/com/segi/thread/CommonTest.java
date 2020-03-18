package com.segi.thread;

import org.junit.Test;

/**
 * @author chenzx
 * @date 2018-12-10 下午 12:56
 */
public class CommonTest {

    @Test
    public void testInterruptException() {
        Runnable runnable = () -> {
            try {
                System.out.println("线程：" + Thread.currentThread().getName());
                System.out.println("开睡2秒");
                Thread.sleep(2000);
                System.out.println("调用interrupt()");
                System.out.println("调用interrupt()结束");
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                System.out.println("遇到了InterruptedException");
            }
        };
        new Thread(runnable).start();
        System.out.println("线程：" + Thread.currentThread().getName());
    }
}
