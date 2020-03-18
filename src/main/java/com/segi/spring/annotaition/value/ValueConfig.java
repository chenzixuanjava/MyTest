package com.segi.spring.annotaition.value;

import com.segi.spring.annotaition.value.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import sun.applet.Main;

import java.util.Iterator;

/**
 * @author chenzx
 * @date 2019-02-14 下午 2:41
 */
@Configuration
//声明属性源
//这个属性文件会加载到Spring的Environment中，稍后可以从这里检索属性
@PropertySource("classpath:properties/value/common.properties")
@ImportResource(locations = {"classpath:spring/applicationContext-common.xml"})
public class ValueConfig {

    @Autowired
    Environment evn;

    @Value("${person.name}")
    private String name;

    @Value("#{person.age}")
    private Integer age;

    @Bean
    public Person person() {
        //evn.getProperty() 从属性文件中获取值
        return new Person(evn.getProperty("person.name"), evn.getProperty("person.age", Integer.class), evn.getProperty("person.phone", "18818536666"));
    }

    @Bean
    public Person person3() {
        return new Person(name, null, null);
    }

    /*@Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/

    @Bean
    public Person person4(){
        return new Person(null, age, null);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValueConfig.class);
        context.getBean(Person.class);
    }
}
