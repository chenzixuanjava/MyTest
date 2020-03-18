package com.segi.designPattern.struct.adapter.demo2;

/**
 * @author chenzx
 * @date 2018-11-26 下午 3:20
 */
public class Mp4SuperVideoPlayer implements SuperVideoPlayer {
    @Override
    public void playSuperVideo(String videoName) {
        System.out.println("playing MP4video:" + videoName);
    }
}
