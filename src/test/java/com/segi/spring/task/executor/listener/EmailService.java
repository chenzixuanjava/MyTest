package com.segi.spring.task.executor.listener;

import com.segi.springmvc.model.Person;
import lombok.Data;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-19 下午 8:43
 */
@Data
public class EmailService implements ApplicationEventPublisherAware {

    private List<String> blackList;

    private ApplicationEventPublisher eventPublisher;

    /*
    * Spring容器会探测到实现了ApplicationEventPublisherAware接口，并调用此方法。传进来容器本身
     * */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void sendEmail(String message, String content) {
        if (blackList.contains(message)) {
            eventPublisher.publishEvent(new BlackListEvent<Person>(this, message, content)/*new BlackListEvent2(this, message, content)*/);
//            eventPublisher.publishEvent(new BlackListEvent2(this, message, content));
            System.out.println("发布事件BlackListEvent完成");
            return;
        }
    }

    @Async
    public void printAsync() {
        System.out.println("printAsync：hello" + " Thread: " + Thread.currentThread().getName());
    }

}
