package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-04 上午 10:37
 */
public class SleepMessages {

    public static void main(String[] args){
        String msgs[] = {"chen", "zi", "xuan", "24"};

        for (int i = 0; i < msgs.length; i++) {
            try {
                Thread.sleep(4000);
                if (i == 2) {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("我被中断了，i = " + i);
                break;
            }
            System.out.println(msgs[i]);
        }
    }
}
