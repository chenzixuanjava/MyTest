package com.segi.designPattern.struct.adapter.demo2;

/**
 * @author chenzx
 * @date 2018-11-26 下午 3:28
 */
public class CommonVideoPlayer implements VideoPlayer {
    private SuperVideoPlayerAdapter superVideoPlayerAdapter;

    @Override
    public void play(String videoType, String videoName) {
        if (videoType.equalsIgnoreCase("common")) {
            System.out.println("playing commonVideo:" + videoName);
        } else if (videoType.equalsIgnoreCase("mp4")) {
            superVideoPlayerAdapter = new SuperVideoPlayerAdapter(new Mp4SuperVideoPlayer());
            superVideoPlayerAdapter.play(videoType, videoName);
        } else if (videoType.equalsIgnoreCase("wma")) {
            superVideoPlayerAdapter = new SuperVideoPlayerAdapter(new WmaSuperVideoPlayer());
            superVideoPlayerAdapter.play(videoType, videoName);
        } else {
            System.out.println("invalid videoType!");
        }
    }
}
