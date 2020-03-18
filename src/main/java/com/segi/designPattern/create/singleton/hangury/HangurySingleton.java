package com.segi.designPattern.create.singleton.hangury;

/**
 * @author chenzx
 * @date 2018-12-18 下午 8:01
 */
public class HangurySingleton {

    private static HangurySingleton singleton = new HangurySingleton();

    private HangurySingleton() {

    }

    public static HangurySingleton getInstatnce() {
        return singleton;
    }
}
