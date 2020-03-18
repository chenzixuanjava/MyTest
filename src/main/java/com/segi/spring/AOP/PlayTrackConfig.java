package com.segi.spring.AOP;

import com.google.common.collect.Lists;
import com.segi.spring.AOP.model.CompactDiscImpl;
import com.segi.spring.IOC.model.CompactDisc;
import com.segi.spring.IOC.model.CompactDiscImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-08 下午 7:18
 */
@Configuration
//@EnableAspectJAutoProxy
@ComponentScan
public class PlayTrackConfig {

    @Bean
    public CompactDiscImpl compactDisc() {
        CompactDiscImpl compactDisc = new CompactDiscImpl();
        compactDisc.setTitle("love");
        compactDisc.setArticle("MC");
        List<String> tracks = Lists.newArrayList("track1", "track2", "track3 ");
        compactDisc.setTracks(tracks);
        return compactDisc;
    }
}
