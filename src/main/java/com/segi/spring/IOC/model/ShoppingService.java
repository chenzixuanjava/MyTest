package com.segi.spring.IOC.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-08 上午 10:35
 */
@Component
public class ShoppingService {
    @Autowired
    private ShoppingCart shoppingCart;

}
