package com.segi.common.defaultlog.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-09-29 上午 9:59
 */
@Data
@Component
public class Person {

    private String name;
    private Integer age;
}
