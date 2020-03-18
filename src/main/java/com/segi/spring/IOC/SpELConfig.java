package com.segi.spring.IOC;

import com.google.common.collect.Lists;
import com.segi.spring.IOC.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-08 下午 3:36
 */
@Configuration
@ComponentScan
public class SpELConfig {

    //?.判断前面的是否为空，为空返回空，不为空调用后面的方法
//    @Value("#{compactDiscImpl2.article?.toUpperCase()}")
    //?:三元运算符，如果前面的值为空就取后面的值
    @Value(("#{compactDiscImpl2.article?:'haha'}"))
    private String article;

    //T()运算符，得到Class对象，通常用于调用其静态方法或者常量
    @Value("#{T(java.lang.Math).PI}")
    private String title;

    //查询运算符：.?[] .^[] .$[]
    //投影运算符：.![]
    @Value(("#{tracks.tracks.?[track eq 'track2'].![track]}"))
//    @Autowired
    private List<String> tracks;

    @Bean
    public CompactDiscImpl2 compactDiscImpl2() {
        return new CompactDiscImpl2("love", null);
    }

    @Bean
    public CompactDiscImpl3 compactDiscImpl3() {
        return new CompactDiscImpl3(title, article, tracks);
    }

    @Bean
    public Tracks tracks() {
        List<Track> tracks = Lists.newArrayList(new Track("track1"), new Track("track2"), new Track("track3"));
        return new Tracks(tracks);
    }
}
