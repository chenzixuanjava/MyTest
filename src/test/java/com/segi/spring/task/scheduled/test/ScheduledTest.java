package com.segi.spring.task.scheduled.test;

import com.segi.spring.task.scheduled.SchedulerConfig;
import com.segi.spring.task.scheduled.annotation.SchedulerAnnotationService;
import com.segi.spring.task.scheduled.common.MySchedulerService;
import com.segi.spring.task.scheduling.MySchedulingConfiguerer;
import com.segi.spring.task.scheduling.SchedulingConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-22 上午 9:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SchedulingConfig.class)
public class ScheduledTest {

    /*@Autowired
    ScheduledService scheduledService;*/

    /*@Autowired
    TaskScheduler taskScheduler;*/

    /*@Autowired
    SchedulerAnnotation schedulerAnnotation;*/

    /*@Autowired
    MyScheduler myScheduler;*/

    /*@Autowired
    MySchedulerService mySchedulerService;*/

    /*@Autowired
    MySchedulingConfiguerer mySchedulingConfiguerer;*/

    //果然，还是得在main方法里才有效啊，启动spring容器就有效。在Junit的@Test方法里没有效果。
    public static void main(String[] args) {
        //普通的调度器
        /*ApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
        MySchedulerService mySchedulerService = context.getBean(MySchedulerService.class);
        mySchedulerService.doSchedulerTask();*/
//        ScheduledService demo1 = context.getBean(ScheduledService.class);
//        demo1.doSomeThing();
//        TaskScheduler taskScheduler = context.getBean(TaskScheduler.class);
//        new SchedulerExample(taskScheduler).schedule();
//        new TaskAnnotation().schedule();
//        TaskAnnotation taskAnnotation = context.getBean(TaskAnnotation.class);
//        taskAnnotation.schedule();
        //注解的调度器
        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
        /*SchedulerAnnotationService schedulerAnnotationService = context.getBean(SchedulerAnnotationService.class);
        schedulerAnnotationService.doSchedulerTadkWithFixedDelay();*/
    }

    /*@AnnotationAsyncTest
    public void test1() {
        Runnable run = () -> {
            scheduledService.doSomeThing();
        };
        ThreadPoolTaskScheduler threadPoolTaskScheduler = (ThreadPoolTaskScheduler) taskScheduler;
    }

    @AnnotationAsyncTest
    public void test2() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        taskScheduler.initialize();
        Runnable runnable = () -> {
            System.out.println("执行一次");
        };
        taskScheduler.schedule(runnable, new CronTrigger("0/1 * * * * ?"));
    }*/

    /*@AnnotationAsyncTest
    public void testAsync() throws ExecutionException, InterruptedException {
        *//*
     * ①默认SimpleAsyncTaskExecutor
     * ②若容器中有TaskExecutor，这用容器中指定的
     * ③容器中有多个TaskExecutor，用默认的；
     * ④可以@Async(value="executorName")
     * *//*
        System.out.println(schedulerAnnotation.helloAsync1("hah").get());
        schedulerAnnotation.helloAsync2("hah");
    }*/



}
