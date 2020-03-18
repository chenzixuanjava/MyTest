package com.segi.spring.IOC.model;

/**
 * @author chenzx
 * @date 2018-10-07 下午 10:35
 */
public class ProfileDev implements MyProfile {
    @Override
    public void show() {
        System.out.println("开发环境");
    }
}
