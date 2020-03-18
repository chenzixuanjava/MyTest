package com.segi.spring.IOC;

import com.segi.spring.IOC.model.ShoppingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-08 上午 10:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ScopeConfig.class})
public class ScopeTest {
    @Autowired
    ShoppingService shoppingService;
    @Test
    public void scope() {
        System.out.println(shoppingService);
    }
}
