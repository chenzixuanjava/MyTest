package com.segi.spring.IOC;

import com.segi.spring.IOC.model.CompactDiscImpl2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-08 上午 10:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropertiesConfig.class)
public class PropertiesTest {
    @Autowired
    CompactDiscImpl2 compactDiscImpl2;

    @Test
    public void properties() {
        System.out.println(compactDiscImpl2);
    }
}
