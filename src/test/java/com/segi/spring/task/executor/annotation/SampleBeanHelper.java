package com.segi.spring.task.executor.annotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2019-03-26 下午 3:11
 */
@Component
public class SampleBeanHelper {

    @Async
    public void initHelp() {
        System.out.println("SampleBeanHelper " + Thread.currentThread().getName());
    }
}
