package com.segi.common.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenzx
 * @date 2018-09-29 下午 7:21
 */
public class CommonTest3 {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonTest3.class);

    @Test
    public void test1() {
        LOGGER.info("hello");
        System.out.printf("%1$6.2f", 1.1111);
    }
}
