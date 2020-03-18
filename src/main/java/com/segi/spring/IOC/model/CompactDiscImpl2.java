package com.segi.spring.IOC.model;

import lombok.Data;

/**
 * @author chenzx
 * @date 2018-09-30 下午 6:41
 */
@Data
public class CompactDiscImpl2 implements CompactDisc{
    private String title;
    private String article;

    public CompactDiscImpl2(String title, String article) {
        this.title = title;
        this.article = article;
    }

    @Override
    public void play() {
        System.out.println("title: " + title + "\n" + "article: " + article);
    }
}
