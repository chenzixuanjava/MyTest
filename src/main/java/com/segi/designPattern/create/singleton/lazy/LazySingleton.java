package com.segi.designPattern.create.singleton.lazy;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:01
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() {

    }

    public static LazySingleton getInstatnce() {
        if (null == singleton) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
