package com.segi.spring.task.executor.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chenzx
 * @date 2018-10-22 下午 12:50
 */
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... params) {
        System.out.println("msg:" + throwable.getMessage());
        System.out.println("mehtod:" + method.getName());
        System.out.println("params:" + Arrays.asList(params));
    }
}
