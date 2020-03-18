package com.segi.spring.task.executor.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @author chenzx
 * @date 2019-03-26 上午 10:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationConfig.class)
public class AnnotationAsyncTest {

    @Autowired
    AnnotationAsyncExample annotationAsyncExample;

    @Autowired
    SampleBeanInitializer sampleBeanInitializer;

    @Test
    public void testVoidParamVoidReturn() {
        for (int i = 0; i < 25; i++) {
            annotationAsyncExample.voidParamVoidReturn();
        }
    }

    @Test
    public void testWithParamVoidReturn() {
        for (int i = 0; i < 25; i++) {
            annotationAsyncExample.withParamVoidReturn("msg" + i);
        }
    }

    @Test
    public void testWithParamWithReturn() throws Exception {
        for (int i = 0; i < 25; i++) {
            Future<String> future = annotationAsyncExample.withParamWithReturn("msg" + i);
            System.out.println(future.get());
        }
    }

    @Test
    public void testInit() {
        sampleBeanInitializer.initia();
    }

    @Test
    public void testExecuteWithMultiExecutor() {
        for (int i = 0; i < 25; i++) {
            annotationAsyncExample.executeWithMultiExecutor();
        }
    }
}
