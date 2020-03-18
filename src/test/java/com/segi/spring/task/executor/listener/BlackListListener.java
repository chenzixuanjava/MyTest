package com.segi.spring.task.executor.listener;

import lombok.Data;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author chenzx
 * @date 2018-10-19 下午 8:58
 */
@Data
public class BlackListListener implements ApplicationListener<BlackListEvent> {
    private String notificationAddress;

    @Override
    public void onApplicationEvent(BlackListEvent blackListEvent) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("onApplicationEvent监听到的消息：" + blackListEvent + " Thread: " + Thread.currentThread().getName());
    }

    /*
     * 指定事件类型：
     * ①方法参数
     * ②当需要监听多个事件，或者不想通过传参的方式，可以@EventListener(classes={xxx.class})
     * */
    @EventListener(classes = {BlackListEvent.class/*, BlackListEvent2.class*/})
//    @Order(1)
    /*
     * 可以在方法上提供@Async注释，以便该方法的调用将异步进行。换句话说，调用方将在调用后立即返回，
     * 方法的实际执行将发生在提交给Spring TaskExecutor的任务中
     *
     * 注：
     * ①异常不被捕获
     * ②不能返回发布另一个事件
     * */
    @Async("executor")
    /*
     * 由于类型擦除，所以事件会监听过滤掉泛型参数的类，相当于带泛型的子类
     * */
    public void listenEvent() {
        System.out.println("listenEvent监听到了消息" + " Thread: " + Thread.currentThread().getName());
    }

    /*
     * 如果想在处理一个时间后接着发布另一个时间，只需要返回另一个要发布的事件。
     * 注：异步监听不支持这样，异步只能再注入ApplicationEventPublisher手动发布喽
     * */
    @EventListener
//    @Order(2)
//    @Async("executor")
    public BlackListEvent2 listenEvent2(BlackListEvent blackListEvent) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("listenEvent2监听到的消息：" + blackListEvent + " Thread: " + Thread.currentThread().getName());
        return new BlackListEvent2(this, "hello", "hello, i am chen2");
    }

    @EventListener
//    @Order(3)
//    @Async("executor")
    public void listenEvent3(BlackListEvent2 blackListEvent2) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("listenEvent3监听到的消息：" + blackListEvent2 + "Thread: " + Thread.currentThread().getName());
    }

}

