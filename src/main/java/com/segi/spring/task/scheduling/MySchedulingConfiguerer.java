package com.segi.spring.task.scheduling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzx
 * @date 2019-06-20 下午 2:19
 */
@Component
@EnableScheduling
public class MySchedulingConfiguerer implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addCronTask(() -> {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        }, "*/1 * * * * ?");
        scheduledTaskRegistrar.addTriggerTask(() -> {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }, new CronTrigger(""));
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulingConfig.class);
    }
}
