package com.segi.spring.AOP.model.xml;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-09-30 下午 6:41
 */
@Data
@NoArgsConstructor
public class CompactDiscImpl implements CompactDisc {
    private String title;
    private String article;
    private List<String> tracks;

    public CompactDiscImpl(String title, String article, List<String> tracks) {
        this.title = title;
        this.article = article;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("title: " + title + "\n" + "article: " + article);
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println("track-" + i + ": " + tracks.get(i));
        }
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("磁道" + trackNumber + "播放一次");
    }
}
