package com.segi.spring.IOC.model;

import lombok.Data;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-09-30 下午 6:41
 */
@Data
public class CompactDiscImpl3 implements CompactDisc{
    private String title;
    private String article;
    private List<String> tracks;

    public CompactDiscImpl3(String title, String article, List<String> tracks) {
        this.title = title;
        this.article = article;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        /*System.out.println("title: " + title + "\n" + "article: " + article);
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println("track-" + i + ": " + tracks.get(i));
        }*/
    }
}
