package com.segi.spring.task.scheduled.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzx
 * @date 2019-02-24 上午 11:37
 */
@Service
public class MySchedulerService{

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private TaskScheduler scheduler;

    public void doSchedulerTask() {
        scheduler.schedule(() -> System.out.println(Thread.currentThread().getName() + ": " + format.format(new Date())),
                new CronTrigger("*/1 * * * * ?"));
    }
}
