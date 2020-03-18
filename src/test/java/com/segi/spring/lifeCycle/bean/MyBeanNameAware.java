package com.segi.spring.lifeCycle.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-22 下午 7:06
 */
@Component
public class MyBeanNameAware implements BeanNameAware {

    /*
    * 实现了BeanNameAware的对象获取了改对象的名称定义
    * */
    @Override
    public void setBeanName(String s) {
        System.out.println("MyBeanNameAware的setBeanName：" + s);
    }
}
