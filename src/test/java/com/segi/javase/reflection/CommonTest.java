package com.segi.javase.reflection;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author chenzx
 * @date 2019-03-08 下午 5:59
 */
public class CommonTest {

    @Test
    public void testGetDeclaredFields() {
        /*
        1、返回类或接口的属性的数组，包括所有访问范围的（public, protected, defalut, private）
        2、不返回继承的属性
        3、Class 对象表示数组，基本类型，void时，返回空的数组
        4、返回的数组未排序，不能保证顺序
         */
        Class<Person> personClass = Person.class;
        Field[] personFields = personClass.getDeclaredFields();
        for (Field field : personFields) {
            System.out.println(field);
        }

        System.out.println("===================");

        Class<Work> workClass = Work.class;
        Field[] workFields = workClass.getDeclaredFields();
        for (Field field : workFields) {
            System.out.println(field);
        }
        System.out.println("===================");

        Integer[] integers = {1, 2, 3};
        Class<? extends Integer[]> integersClass = integers.getClass();
        Field[] integersClassDeclaredFields = integersClass.getDeclaredFields();
        for (Field field : integersClassDeclaredFields) {
            System.out.println(field);
        }

        System.out.println("===================");
    }
}
