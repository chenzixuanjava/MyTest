package com.segi.spring.IOC.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenzx
 * @date 2018-09-30 上午 10:18
 */
@Data
@NoArgsConstructor
public class Person {
    private String name;

    Man man;

    public Person(Man man) {
        this.man = man;
    }

    public void manEea() {
        man.eat();
    }
}
