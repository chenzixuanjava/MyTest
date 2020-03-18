package com.segi.common.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenzx
 * @date 2018-11-26 下午 4:26
 */
@Data
@AllArgsConstructor
public class Person implements Cloneable {
    private String name;
    private Integer age;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
