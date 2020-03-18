package com.segi.spring.lifeCycle.bean2;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-23 上午 9:25
 */
@Component
@Data
public class MyBeanPostProcessor implements BeanPostProcessor
{
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("name: " + s + " created: " + o);
        return o;
    }
}
