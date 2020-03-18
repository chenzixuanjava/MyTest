package com.segi.spring.AOP.model;

import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-08 下午 6:54
 */
@Component
public class PerformenceImpl implements Performence {
    @Override
    public void perform() {
        System.out.println("正式表演");
    }
}
