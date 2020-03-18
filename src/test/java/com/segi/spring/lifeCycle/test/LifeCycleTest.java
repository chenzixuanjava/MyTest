package com.segi.spring.lifeCycle.test;

import com.segi.spring.lifeCycle.bean.LifeCycleConfig;
import com.segi.spring.lifeCycle.bean.MyApplicationContextAware;
import com.segi.spring.lifeCycle.bean2.BeanPostProcessConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Base64;

/**
 * @author chenzx
 * @date 2018-10-22 下午 5:15
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {LifeCycleConfig.class})
public class LifeCycleTest {
    /*@Autowired
    CustomizeBean initMethodBean;*/
    ApplicationContext context = null;

//    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    }

    @Test
    public void testInitMethod() {
        //主方法退出，在app关闭前调用hook，优雅地关闭程序，释放资源
        ((AnnotationConfigApplicationContext) context).registerShutdownHook();

    }

    @Test
    public void testApplicationContextAware() {
        MyApplicationContextAware bean = context.getBean(MyApplicationContextAware.class);
        bean.doSomethingWihtApplication();
    }

    @Test
    public void testBeanPostProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessConfig.class);

    }

    @Test
    public void test() {
        Assert.assertEquals(1, 2);
    }

    @Test
    public void testBase64() {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = encoder.encode(new byte[]{1});
        for (byte aByte : bytes) {
            System.out.print((char)aByte);
        }

        System.out.println("\n========");

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode("AQ==");
        for (byte b : decode) {
            System.out.print(b);
        }
    }

}
