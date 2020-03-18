package com.segi.common.spring.IOC;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author chenzx
 * @date 2018-11-22 下午 3:29
 */
public class MyFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person("chenzixuan", 24);
    }

    @Override
    public Class<Person> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
