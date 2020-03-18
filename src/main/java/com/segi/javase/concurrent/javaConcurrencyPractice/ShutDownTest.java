package com.segi.javase.concurrent.javaConcurrencyPractice;

/**
 * @author chenzx
 * @date 2019-11-28 上午 10:52
 */
public class ShutDownTest {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new CalThread());
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.exit(1);
            }
            System.out.println(i);

        }
    }
}

class CalThread extends Thread{

    @Override
    public void run() {
        System.out.println("触发关闭钩子");
    }
}
