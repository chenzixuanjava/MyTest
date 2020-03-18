package com.segi.spring.AOP.model.xml;

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
public class PlayTrackCounter {
    Map<Integer, Integer> countsMap = new HashMap<>();

    public void playTrack(int trackNumber) {

    }

    public void count(int trackNumber) {
        int count = getTrackNuberCount(trackNumber);
        countsMap.put(trackNumber, count + 1);
    }

    public int getTrackNuberCount(int trackNumber) {
        return countsMap.containsKey(trackNumber) ? countsMap.get(trackNumber) : 0;
    }
}
