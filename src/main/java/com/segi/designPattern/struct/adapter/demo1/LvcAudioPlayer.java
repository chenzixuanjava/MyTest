package com.segi.designPattern.struct.adapter.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 2:59
 */
public class LvcAudioPlayer implements AdvancedAudioPlayer {
    @Override
    public void playLvc(String fileName) {
        System.out.println("playing lvc:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
