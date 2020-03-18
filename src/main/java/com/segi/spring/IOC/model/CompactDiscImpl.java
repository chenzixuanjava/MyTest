package com.segi.spring.IOC.model;

/**
 * @author chenzx
 * @date 2018-09-30 下午 4:37
 */
//@Component
public class CompactDiscImpl implements CompactDisc{

    @Override
    public void play() {
        System.out.println("play music");
    }
}
