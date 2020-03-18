package com.segi.designPattern.struct.adapter.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 3:01
 */
public class AudioAdapter implements MediaPlayer{

    private AdvancedAudioPlayer advancedAudioPlayer;

    public AudioAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("lvc")) {
            advancedAudioPlayer = new LvcAudioPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedAudioPlayer = new Mp4AudioPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("lvc")) {
            advancedAudioPlayer.playLvc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedAudioPlayer.playMp4(fileName);
        }
    }

}
