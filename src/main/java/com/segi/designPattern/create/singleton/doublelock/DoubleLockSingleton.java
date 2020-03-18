package com.segi.designPattern.create.singleton.doublelock;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:01
 */
public class DoubleLockSingleton {

    private static DoubleLockSingleton singleton;

    private DoubleLockSingleton() {

    }

    public static DoubleLockSingleton getInstatnce() {
        if (null == singleton) {
            synchronized (DoubleLockSingleton.class) {
                if (null == singleton) {
                    singleton = new DoubleLockSingleton();
                }
            }
        }
        return singleton;
    }
}
