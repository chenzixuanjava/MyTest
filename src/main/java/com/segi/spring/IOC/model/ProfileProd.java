package com.segi.spring.IOC.model;

/**
 * @author chenzx
 * @date 2018-10-07 下午 10:36
 */
public class ProfileProd implements MyProfile {
    @Override
    public void show() {
        System.out.println("生产环境");
    }
}
