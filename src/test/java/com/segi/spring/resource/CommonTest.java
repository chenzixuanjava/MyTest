package com.segi.spring.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.StaticWebApplicationContext;

/**
 * @author chenzx
 * @date 2020-01-11 上午 9:28
 */
public class CommonTest {

    @Test
    public void testResourceLoader01() {
        ApplicationContext context01 = new ClassPathXmlApplicationContext();
        ApplicationContext context02 = new FileSystemXmlApplicationContext();
        ApplicationContext context03 = new StaticWebApplicationContext();

        System.out.println(context01.getResource("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\properties\\value\\common.properties"));
        System.out.println(context02.getResource("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\properties\\value\\common.properties"));
        System.out.println(context03.getResource("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\properties\\value\\common.properties"));
    }

    @Test
    public void testResourceLoader02() {
        ApplicationContext context01 = new ClassPathXmlApplicationContext();
        ApplicationContext context02 = new FileSystemXmlApplicationContext();
        System.out.println(context01.getResource("classpath:properties\\value\\common.properties"));
        System.out.println(context02.getResource("classpath:properties\\value\\common.properties"));
    }

    @Test
    public void testResourceLoader03() {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        System.out.println(context.getResource("file:///D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\properties\\value\\common.properties"));
        System.out.println(context.getResource("http://www.baidu.com"));
    }

    @Test
    public void testResourceLoad() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-common.xml");
        ResourceLoadBean resourceLoadBean = context.getBean(ResourceLoadBean.class);
        System.out.println(resourceLoadBean.getTemplate());
    }

    @Test
    public void testClasspath() {
        System.out.println(getClass().getClassLoader().getResource("classpath*:"));
    }
}
