package com.segi.spring.IOC;

import com.segi.spring.IOC.model.MagicBean;
import com.segi.spring.IOC.model.MagicExistsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenzx
 * @date 2018-10-08 上午 8:48
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
