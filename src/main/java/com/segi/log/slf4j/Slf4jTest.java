package com.segi.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenzx
 * @date 2019-07-18 上午 10:44
 */
public class Slf4jTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        LOGGER.debug("This is debug message.");
        // 记录info级别的信息
        LOGGER.info("This is info message.");
        // 记录error级别的信息
        LOGGER.error("This is error message.");
    }
}
