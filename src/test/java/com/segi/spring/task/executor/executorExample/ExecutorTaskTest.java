package com.segi.spring.task.executor.executorExample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-12-18 上午 9:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TaskConfig.class)
public class ExecutorTaskTest {

    @Autowired
    MessagePrintExample example;

    @Test
    public void hello() {
        example.printMessage();
    }
}
