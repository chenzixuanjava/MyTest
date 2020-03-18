package com.segi.spring.AOP.model;

import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author chenzx
 * @date 2018-10-08 下午 6:19
 */
//@Data
@Aspect
public class Audience {

    @Pointcut(value = "execution(* com.segi.spring.AOP.model.Performence.perform(..))")
    public void performence() {

    }

    @Before(value = "performence()")
    public void sliceCellPhone() {
        System.out.println("手机静音");
    }

    @Before(value = "performence()")
    public void takeSeat() {
        System.out.println("坐下");
    }

    @After(value = "performence()")
    public void clap() {
        System.out.println("鼓掌");
    }

    @AfterThrowing(value = "performence()")
    public void returnMoney() {
        System.out.println("退钱");
    }

    @Around(value = "performence()")
    public void watchPerformence(ProceedingJoinPoint jp) {
        try {
            System.out.println("==手机静音==");
            System.out.println("==坐下==");
            jp.proceed();
            System.out.println("==鼓掌==");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("==退钱==");
        }

    }
}
