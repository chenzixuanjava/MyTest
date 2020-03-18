package com.segi.spring.IOC;

import com.segi.spring.IOC.model.CompactDisc;
import com.segi.spring.IOC.model.CompactDiscImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenzx
 * @date 2018-10-07 下午 9:56
 */
@Configuration
public class CDConfig {
    @Bean
    public CompactDisc compactDisc() {
        return new CompactDiscImpl();
    }
}
