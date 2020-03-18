package com.segi.spring.annotaition.value.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author chenzx
 * @date 2019-02-14 下午 2:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    public String name;
    public Integer age;
    public String phone;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
