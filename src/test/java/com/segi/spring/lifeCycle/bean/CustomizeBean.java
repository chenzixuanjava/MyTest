package com.segi.spring.lifeCycle.bean;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenzx
 * @date 2018-10-22 下午 5:11
 */
@Data
public class CustomizeBean implements InitializingBean, DisposableBean,/* AutoCloseable,*/ Cloneable, SmartLifecycle {

    /*
    * 1、要求：空参，否则抛BeanDefinitionValidationException异常
    * 2、如果<beans 的属性default-init-method指定了初始化方法的名字，那么所有的bean的该名字的方法将会成为初始化方法。
    * default-destroy-method也一样。如果要自定自己的初始化方法名称，可以在bean中用init-method和destroy-method
    * */
    public void initMethod() {
        System.out.println("自定义init-method");
    }

    /*
     * 要求：空参，否则抛BeanDefinitionValidationException异常
     * */
    public void destroyMethod() {
        System.out.println("自定义destroy-method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@preDestroy");
    }

    /*实现了AutoClosable或Closable的bean，如果没有指定自定义的destroy方法和没有实现DisposableBean，Spring会自动探测close或shutdown方法
    * 同时存在调用close
    * */
    /*@Override
    public void close() throws Exception {
        System.out.println("自定义close");
    }*/

    public void shutdown() {
        System.out.println("自定义shutdown");
    }

   /* @Override
    public void start() {
        System.out.println("Lifecycle.start()");
    }

    *//*
    * 只调用了Lifecycle.stop()方法（所有销毁方法之前调用）
    * *//*
    @Override
    public void stop() {
        System.out.println("Lifecycle.stop()");
    }*/

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
        return 1;
    }
}
