package com.segi.designPattern.struct.adapter.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 2:59
 */
public class Mp4AudioPlayer implements AdvancedAudioPlayer {
    @Override
    public void playLvc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4:" + fileName);
    }
}
