package com.segi.spring.task.executor.listener;

import com.segi.spring.task.executor.EventConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2019-02-01 下午 3:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EventConfig.class})
public class ListenerTest {

    @Autowired
    EmailService emailService;

    @Test
    public void test1() {
        emailService.sendEmail("chenzixuan@qq.com", "hello, i am chen");
    }

    @Test
    public void test2() {
        emailService.printAsync();
    }
}
