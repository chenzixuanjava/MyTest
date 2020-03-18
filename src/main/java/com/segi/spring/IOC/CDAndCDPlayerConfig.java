package com.segi.spring.IOC;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chenzx
 * @date 2018-10-07 下午 10:00
 */
@Configuration
//@Import({CDConfig.class, CDPlayerConfig.class})
@Import(CDPlayerConfig.class)
//@ImportResource(locations = {"classpath:spring/applicationContext-common.xml"})
public class CDAndCDPlayerConfig {
}
