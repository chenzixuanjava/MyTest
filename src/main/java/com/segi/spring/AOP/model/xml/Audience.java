package com.segi.spring.AOP.model.xml;

import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-08 下午 6:19
 */
@Data
public class Audience {

    private GF gf;

    public void sliceCellPhone() {
        System.out.println("手机静音");
    }

    public void takeSeat() {
        System.out.println("坐下");
    }

    public void clap() {
        System.out.println("鼓掌");
        gf.scream();
    }

    public void returnMoney() {
        System.out.println("退钱");
    }

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
