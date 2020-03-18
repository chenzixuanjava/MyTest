package com.segi.designPattern.create.singleton.staticclass;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:18
 */
public class StaticClassSingleton {
    private static class InnerClass {
        private static StaticClassSingleton singleton = new StaticClassSingleton();
    }

    private StaticClassSingleton() {

    }

    public static final StaticClassSingleton getInstance() {
        return InnerClass.singleton;
    }
}
