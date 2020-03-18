package com.segi.spring.IOC.model;

import com.segi.spring.IOC.annotation.Cold;
import com.segi.spring.IOC.annotation.Ice;
import com.segi.spring.IOC.annotation.Pop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-08 上午 9:35
 */
@Component
@Cold
@Pop
public class Popsicle implements Dessert {
}
