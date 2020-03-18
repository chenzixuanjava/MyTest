package com.segi.spring.task.executor.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chenzx
 * @date 2019-03-26 下午 3:12
 */
@Component
public class SampleBeanInitializer {

    @Autowired
    SampleBeanHelper sampleBeanHelper;

    @PostConstruct
//    @Async
    public void initia() {
//        sampleBeanHelper.initHelp();
        System.out.println("SampleBeanInitializer " + Thread.currentThread().getName());
    }
}
