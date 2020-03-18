package com.segi.spring.IOC;

import com.segi.spring.IOC.model.MyProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-07 下午 10:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
//@ActiveProfiles("prod")
public class ProfileTest {
    @Autowired
    MyProfile profile;

    /*
     * 作为DispatcherServlet的初始化参数；
     * 作为Web应用的上下文参数；
     * 作为JNDI条目；
     * 作为环境变量；
     * 作为JVM的系统属性；
     * 在集成测试类上，使用@ActiveProfiles注解设置。
     */
    @Test
    public void profile() {
        profile.show();
    }
}
