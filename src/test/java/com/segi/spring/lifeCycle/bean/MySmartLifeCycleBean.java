package com.segi.spring.lifeCycle.bean;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-22 下午 6:16
 */
//@Component
public class MySmartLifeCycleBean implements SmartLifecycle {

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        System.out.println("==MySmartLifeCycleBean.stop");
    }

    @Override
    public void start() {
        System.out.println("==MySmartLifeCycleBean.start");
    }

    @Override
    public void stop() {
        System.out.println("==MySmartLifeCycleBean.stop");
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    /*
     * 普通的bean Phase为0
     * */
    @Override
    public int getPhase() {
        return 2;
    }
}
