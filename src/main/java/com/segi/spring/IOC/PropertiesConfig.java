package com.segi.spring.IOC;

import com.segi.spring.IOC.model.CompactDiscImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * @author chenzx
 * @date 2018-10-08 上午 10:57
 */
@Configuration
@ComponentScan
@PropertySource(value = {"classpath:properties/common.properties"})
public class PropertiesConfig {

    @Autowired
    Environment evn;

    //@Value("${cd.article}")
    //SpEL表达式
    @Value("#{systemProperties[\"cd.article\"]}")
    private String article;

    @Bean
    public CompactDiscImpl2 compactDiscImpl2() {
        return new CompactDiscImpl2(evn.getProperty("cd.title"), article);
    }

}
