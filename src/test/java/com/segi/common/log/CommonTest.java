package com.segi.common.log;

import com.segi.common.defaultlog.RootConfig;
import com.segi.common.defaultlog.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenzx
 * @date 2018-09-29 上午 10:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class CommonTest {
    @Autowired
    Person person;

    @Test
    public void testLogging() {
        //使用java.util.logging默认日志框架
        Logger logger = Logger.getLogger(CommonTest.class.getName());
        logger.log(Level.INFO, "开始");
        System.out.println(person);
        logger.info("结束");
    }
}
