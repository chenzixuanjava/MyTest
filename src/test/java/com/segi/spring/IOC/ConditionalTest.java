package com.segi.spring.IOC;

import com.segi.spring.IOC.model.MagicBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-08 上午 8:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionConfig.class)
public class ConditionalTest {
    @Autowired
    MagicBean magicBean;

    @Test
    public void conditional() {
        Assert.assertNotNull(magicBean);
    }
}
