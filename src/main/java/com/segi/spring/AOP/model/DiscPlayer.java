package com.segi.spring.AOP.model;

import lombok.Data;

/**
 * @author chenzx
 * @date 2018-09-30 下午 4:54
 */
//@Component
//@Named
@Data
public class DiscPlayer implements MediaPlayer {
//    @Autowired
    private CompactDisc compactDisc;

    /**
     * Spring创造bean，如果没有默认，就用其它构造器
     */
    public DiscPlayer() {
    }

    /*
     * @Autowired(@Inject)可以标注在:（）
     * ①属性
     * ②构造器
     * ③任何参数满足条件的方法上。
     */
    //    @Autowired
    public DiscPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

//    @Autowired
//    @Inject
    public void injectCD(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
