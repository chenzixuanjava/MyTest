package com.segi.spring.IOC;

import com.segi.spring.IOC.model.CompactDiscImpl3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-08 下午 3:44
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpELConfig.class})
public class SpELTest {
    @Autowired
    CompactDiscImpl3 compactDiscImpl3;

    @Test
    public void spEL() {
        System.out.println(compactDiscImpl3);
    }
}
