package com.segi.spring.task.scheduled;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chenzx
 * @date 2018-10-22 下午 12:50
 */
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        System.out.println(method + "(" + Arrays.asList(objects) + ")" + ": " + throwable.getMessage());
    }
}
