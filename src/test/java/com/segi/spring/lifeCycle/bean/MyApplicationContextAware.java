package com.segi.spring.lifeCycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author chenzx
 * @date 2018-10-22 下午 6:54
 */
@Component
public class MyApplicationContextAware/* implements ApplicationContextAware*/ {

    private ApplicationContext applicationContext;
    /*
    * 1、当一个对象实现了ApplicationContextAware接口时，这个对象被提供了一个ApplicationContext的引用
    * 2、通过Autowired也可以获取ApplicationContext的引用
    * */
//    @Override
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void doSomethingWihtApplication() {
        String[] beanDefinitionNames = this.applicationContext.getBeanDefinitionNames();
        System.out.println("通过ApplicationContext的引用，我可以容器里的bean的名称：" + Arrays.asList(beanDefinitionNames));
    }
}
