package com.segi.spring.AOP.model.xml;

/**
 * @author chenzx
 * @date 2018-10-08 下午 8:05
 */
public class EncorableImpl implements Encorable {
    @Override
    public void imp() {
        System.out.println("我是被引入的方法");
    }
}
