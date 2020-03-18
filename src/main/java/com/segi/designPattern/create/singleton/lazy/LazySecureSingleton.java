package com.segi.designPattern.create.singleton.lazy;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:01
 */
public class LazySecureSingleton {

    private static LazySecureSingleton singleton;

    private LazySecureSingleton() {

    }

    public static synchronized LazySecureSingleton getInstatnce() {
        if (null == singleton) {
            singleton = new LazySecureSingleton();
        }
        return singleton;
    }
}
