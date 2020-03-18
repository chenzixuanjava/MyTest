package com.segi.spring.IOC;

import com.segi.common.spring.IOC.Person;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenzx
 * @date 2018-11-22 下午 3:37
 */
public class BeanFactoryTest {

    @Test
    public void beanFactoryTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-common.xml");
        Object bean = context.getBean("myFactoryBean");
        Object bean2 = context.getBean("myFactoryBean");
        Object bean3 = context.getBean("&myFactoryBean");
        System.out.println((Person)bean);
        System.out.println(bean == bean2);
        System.out.println((FactoryBean)bean3);
    }

}
