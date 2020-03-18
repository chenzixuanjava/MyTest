package com.segi.designPattern.struct.adapter.demo2;

import lombok.AllArgsConstructor;

/**
 * @author chenzx
 * @date 2018-11-26 下午 3:26
 */
@AllArgsConstructor
public class SuperVideoPlayerAdapter implements VideoPlayer{
    private SuperVideoPlayer superVideoPlayer;

    @Override
    public void play(String videoType, String videoName) {
        superVideoPlayer.playSuperVideo(videoName);
    }
}
