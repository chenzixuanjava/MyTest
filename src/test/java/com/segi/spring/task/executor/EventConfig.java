package com.segi.spring.task.executor;

import com.google.common.collect.Lists;
import com.segi.spring.task.executor.listener.BlackListListener;
import com.segi.spring.task.executor.listener.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chenzx
 * @date 2018-10-19 下午 9:14
 */
@Configuration
@ImportResource(locations = "classpath:spring/applicationContext-task.xml")
//@EnableAsync
public class EventConfig/* implements AsyncConfigurer */{

    @Bean
    public BlackListListener blackListListener() {
        BlackListListener blackListListener = new BlackListListener();
        blackListListener.setNotificationAddress("chenzixuan@qq.com");
        return blackListListener;
    }

    @Bean
    public EmailService emailService() {
        EmailService emailService = new EmailService();
        emailService.setBlackList(Lists.newArrayList("chenzixuan@qq.com", "wuping@qq.com"));
        return emailService;
    }

   /* @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.initialize();
        return taskExecutor;
    }*/

   /* @Override
    public Executor getAsyncExecutor() {
        return null;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncUncaughtExceptionHandler();
    }*/

    /*
    * 1、如果活动线程小于core-size，执行器使用空闲线程
    * 2、如果core-size满了，任务将会加入queue，直至queue容量满了（默认无限制）
    * 3、如果queue容量满了，执行器创建新的线程，直至max-size满了
    * 4、如果max-size满了，执行器拒绝任务。
    * */
    /*@Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }*/
}
