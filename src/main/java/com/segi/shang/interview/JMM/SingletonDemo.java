package com.segi.shang.interview.JMM;

import sun.security.jca.GetInstance;

/**
 * @author chenzx
 * @date 2020-02-29 下午 4:27
 */
public class SingletonDemo {
    private static volatile SingletonDemo singletonDemo = null;

    private SingletonDemo() {
        System.out.println("初始化SingletonDemo");
    }

    public static SingletonDemo getInstance() {
        if (null == singletonDemo) {
            synchronized (SingletonDemo.class) {
                if (null == singletonDemo) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    SingletonDemo.getInstance();
                }
            }, "线程" + i).start();
        }
    }

}
