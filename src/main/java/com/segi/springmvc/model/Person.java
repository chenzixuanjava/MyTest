package com.segi.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenzx
 * @date 2018-10-15 下午 6:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id) {
        this.id = id;
    }
}
