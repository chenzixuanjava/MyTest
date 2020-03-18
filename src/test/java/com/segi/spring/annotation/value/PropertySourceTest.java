package com.segi.spring.annotation.value;

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
 * @date 2019-12-28 下午 5:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ValueConfig.class})
public class PropertySourceTest {

    @Autowired
    private Person person;

    @Autowired
    private Person person2;

    @Autowired
    private Person person3;

    @Autowired
    private Person person4;

    @Autowired
    private Person person5;

    @Autowired
    Environment env;

    @Test
    public void testEvn() {
        System.out.println(person);
    }

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
    public void testOthers() {
        System.out.println(Arrays.asList(env.getActiveProfiles()));//[]
        System.out.println(Arrays.asList(env.getDefaultProfiles()));//[default]
        System.out.println(env.acceptsProfiles("test1", "default"));//true
    }

    @Test
    public void testPlaceHolder() {
        System.out.println(person2);
    }

    @Test
    public void testPlaceHolderAnno() {
        System.out.println(person3);
    }

    @Test
    public void testSpElAnno() {
        System.out.println(person4);
    }

    @Test
    public void testSpelXml() {
        System.out.println(person5);
    }
}
