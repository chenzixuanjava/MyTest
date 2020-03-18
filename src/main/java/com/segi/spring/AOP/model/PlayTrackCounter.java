package com.segi.spring.AOP.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenzx
 * @date 2018-10-08 下午 7:10
 */
@Aspect
@Component
public class PlayTrackCounter {
    Map<Integer, Integer> countsMap = new HashMap<>();

    @Pointcut(value = "execution(* com.segi.spring.AOP.model.CompactDiscImpl.playTrack(int)) && args(trackNumber)")
    public void playTrack(int trackNumber) {

    }

    @Before(value = "playTrack(trackNumber)")
    public void count(int trackNumber) {
        int count = getTrackNuberCount(trackNumber);
        countsMap.put(trackNumber, count + 1);
    }

    public int getTrackNuberCount(int trackNumber) {
        return countsMap.containsKey(trackNumber) ? countsMap.get(trackNumber) : 0;
    }
}
