package com.segi.spring.task.executor.executorExample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chenzx
 * @date 2018-12-18 上午 9:33
 */
@Configuration
//@EnableAsync
@ComponentScan
@ImportResource(locations = "classpath:spring/applicationContext-task.xml")
public class TaskConfig {
}
