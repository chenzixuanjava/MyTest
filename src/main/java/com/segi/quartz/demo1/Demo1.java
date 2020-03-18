package com.segi.quartz.demo1;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author chenzx
 * @date 2018-11-20 上午 10:00
 */
public class Demo1 {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory scheFact = new StdSchedulerFactory();
        Scheduler scheduler = scheFact.getScheduler();
        scheduler.start();

    }
}
