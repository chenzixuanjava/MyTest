package com.segi.spring.task.executor.annotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author chenzx
 * @date 2019-03-26 上午 10:43
 */
@Component
public class AnnotationAsyncExample {

    @Async()
    public void voidParamVoidReturn() {
        System.out.println("hello, " + Thread.currentThread().getName());
    }

    @Async
    public void withParamVoidReturn(String msg) {
        System.out.println(msg + " " + Thread.currentThread().getName());
    }

    @Async
    public Future<String> withParamWithReturn(String msg) throws Exception {
        Callable<String> callable = () -> msg + " " + Thread.currentThread().getName();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        return futureTask;
    }

    @Async("executor-two")
    public void executeWithMultiExecutor() {
        System.out.println("hello, " + Thread.currentThread().getName());
    }
}
