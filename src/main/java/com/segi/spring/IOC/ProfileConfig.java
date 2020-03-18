package com.segi.spring.IOC;

import com.segi.spring.IOC.model.MyProfile;
import com.segi.spring.IOC.model.ProfileDev;
import com.segi.spring.IOC.model.ProfileProd;
import com.segi.spring.IOC.model.ProfileQA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author chenzx
 * @date 2018-10-07 下午 10:37
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public MyProfile profileDev() {
        return new ProfileDev();
    }

    @Bean
    @Profile("qa")
    public MyProfile profileQA() {
        return new ProfileQA();
    }

    @Bean
    @Profile("prod")
    public MyProfile profileProd() {
        return new ProfileProd();
    }
}
