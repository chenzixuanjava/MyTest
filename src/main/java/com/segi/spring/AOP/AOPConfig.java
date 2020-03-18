package com.segi.spring.AOP;

import com.segi.spring.AOP.model.Audience;
import com.segi.spring.AOP.model.EncorableAspect;
import org.springframework.context.annotation.*;

/**
 * @author chenzx
 * @date 2018-10-08 下午 6:34
 */
@Configuration
@ComponentScan
//@ImportResource(locations = {"classpath:spring/applicationContext-aop.xml"})
@EnableAspectJAutoProxy
public class AOPConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncorableAspect encorableAspect() {
        return new EncorableAspect();
    }
}
