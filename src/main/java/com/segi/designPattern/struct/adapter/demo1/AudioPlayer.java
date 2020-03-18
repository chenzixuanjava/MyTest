package com.segi.designPattern.struct.adapter.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 3:01
 */
public class AudioPlayer implements MediaPlayer{

    private AudioAdapter audioAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("playing mp3:" + fileName);
        } else if (audioType.equalsIgnoreCase("lvc") || audioType.equalsIgnoreCase("mp4")) {
            audioAdapter = new AudioAdapter(audioType);
            audioAdapter.play(audioType, fileName);
        } else {
            System.out.println("invalid audioType!");
        }
    }

}
