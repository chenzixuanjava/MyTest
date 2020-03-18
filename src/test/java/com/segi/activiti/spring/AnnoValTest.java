package com.segi.activiti.spring;

import com.segi.spring.annotaition.value.ValueConfig;
import com.segi.spring.annotaition.value.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @author chenzx
 * @date 2019-02-14 下午 2:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ValueConfig.class})
public class AnnoValTest {

    @Autowired
    Environment env;

    /*@Autowired
    Person person;*/

    @Autowired
    Person person2;

    /*@Autowired
    Person person3;*/

    /*@AnnotationAsyncTest
    public void testEvn() {
        System.out.println(person);
    }*/

    @Test
    public void testGetReqProp() {
        System.out.println(env.getRequiredProperty("person.namea"));
        //java.lang.IllegalStateException: required key [person.namea] not found
    }

    @Test
    public void testContainsProp() {
        System.out.println(env.containsProperty("person.name"));//true
        System.out.println(env.containsProperty("person.namea"));//false
    }

    @Test
    public void testEnvProf() {
        System.out.println(Arrays.asList(env.getActiveProfiles()));
        System.out.println(Arrays.asList(env.getDefaultProfiles()));
        System.out.println(env.acceptsProfiles("dev"));
    }

    @Test
    public void testGetPerson2() {
        System.out.println(person2);
    }
}
