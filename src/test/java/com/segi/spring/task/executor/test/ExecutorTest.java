package com.segi.spring.task.executor.test;

import com.segi.spring.task.executor.EventConfig;
import com.segi.spring.task.executor.listener.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-19 下午 9:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EventConfig.class)
public class ExecutorTest {

    @Autowired
    EmailService emailService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        EmailService service = context.getBean(EmailService.class);
        service.sendEmail("chenzixuan@qq.com", "发了一封邮件过来");
    }

    @Test
    public void test1() {
        emailService.sendEmail("chenzixuan@qq.com", "发了一封邮件过来");
    }

    @Test
    public void testMessagePrint() {

    }
}
