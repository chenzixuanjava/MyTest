package com.segi.spring.lifeCycle.bean;

import com.segi.spring.lifeCycle.bean.CustomizeBean;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultLifecycleProcessor;

/**
 * @author chenzx
 * @date 2018-10-22 下午 5:11
 */
@Configuration
@ComponentScan
public class LifeCycleConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public CustomizeBean exampleBean() {
        return new CustomizeBean();
    }

    //设置关闭的时间
    @Bean
    public LifecycleProcessor lifecycleProcessor() {
        DefaultLifecycleProcessor lifecycleProcessor = new DefaultLifecycleProcessor();
        lifecycleProcessor.setTimeoutPerShutdownPhase(1000);
        return lifecycleProcessor;
    }
}
