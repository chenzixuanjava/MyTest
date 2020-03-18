package com.segi.spring.task.scheduled.annotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author chenzx
 * @date 2018-12-18 上午 11:38
 */
@Component
public class SchedulerAnnotationService {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void doSchedulerTadkWithFixedDelay() {
        System.out.println(Thread.currentThread().getName() + ": " + format.format(new Date()));
    }
}
