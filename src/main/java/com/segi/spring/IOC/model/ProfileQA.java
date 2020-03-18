package com.segi.spring.IOC.model;

/**
 * @author chenzx
 * @date 2018-10-07 下午 10:36
 */
public class ProfileQA implements MyProfile {
    @Override
    public void show() {
        System.out.println("测试环境");
    }
}
