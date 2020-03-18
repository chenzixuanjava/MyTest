package com.segi.spring.IOC;

import com.segi.spring.IOC.model.CompactDiscImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.segi.spring.IOC.model.CompactDisc;
import com.segi.spring.IOC.model.DiscPlayer;
import org.springframework.context.annotation.Import;

/**
 * @author chenzx
 * @date 2018-09-30 下午 4:38
 */
@Configuration
//@ComponentScan
//@Import(CDConfig.class)
public class CDPlayerConfig {

    /*
     * @Bean创建的bean的id与方法名相同，可以通过改变方法名或者@Bean(name=...)来改变id
     */
    /*@Bean
    public CompactDisc compactDisc() {
        return new CompactDiscImpl();
    }*/

    /*
     * Java配置的装配：
     * 1、通过调用标注了@Bean的返回需要依赖对象的方法传入构造器。（Spring每次调用该方法都会拦截，直接返回已经创建的Bean--单例的）
     * 2、直接在@Bean方法上传入需要装配的实例类型.构造器或者Setter方法设置
     * 第二种种方式引用其他的bean通常是最佳的选择，因为它不会要求将CompactDisc声明到同一个配置类之中。传入的Bean可以以任何方式创建
     */

    /*@Bean
    public DiscPlayer discPlayer() {
      return new DiscPlayer(compactDisc());
    }*/

    /*@Bean
    public DiscPlayer discPlayer(CompactDisc compactDisc) {
        return new DiscPlayer(compactDisc);
    }*/

    @Bean
    public DiscPlayer discPlayer(CompactDisc compactDisc) {
        DiscPlayer discPlayer = new DiscPlayer();
        discPlayer.setCompactDisc(compactDisc);
        return discPlayer;
    }

}
