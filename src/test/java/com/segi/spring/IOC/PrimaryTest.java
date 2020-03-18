package com.segi.spring.IOC;

import com.segi.spring.IOC.annotation.Cold;
import com.segi.spring.IOC.annotation.Ice;
import com.segi.spring.IOC.annotation.Pop;
import com.segi.spring.IOC.model.Dessert;
import com.segi.spring.IOC.model.IceCream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-08 上午 9:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PrimaryConfig.class})
public class PrimaryTest {
    @Autowired
//    @Qualifier("cold")//默认限定符合自定义限定符都可以用
    @Cold
    @Ice
    Dessert dessert;

    @Test
    public void primary() {
//        Assert.assertNotNull(dessert);
        IceCream iceCream = (IceCream) dessert;
        iceCream.setCount(iceCream.getCount() + 1);
        System.out.println(iceCream);
    }
}
