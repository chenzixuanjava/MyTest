package com.segi.spring.AOP;

import com.segi.spring.AOP.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-08 下午 6:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AOPConfig.class})
public class AOPTest {
    @Autowired
    Audience audience;

    @Autowired
    Performence performence;

    @Autowired
    CompactDisc compactDisc;

    @Autowired
    PlayTrackCounter playTrackCounter;

    @Autowired
    Encorable encorable;

    @Test
    public void aop() {
        System.out.println(audience);
        audience.clap();
    }

    @Test
    public void aop2() {
        System.out.println(audience);
        performence.perform();
    }

    @Test
    public void aop3() {
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(2);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);

        Assert.assertEquals(1, playTrackCounter.getTrackNuberCount(1));
        Assert.assertEquals(2, playTrackCounter.getTrackNuberCount(2));
        Assert.assertEquals(2, playTrackCounter.getTrackNuberCount(3));
        Assert.assertEquals(0, playTrackCounter.getTrackNuberCount(4));
    }

    @Test
    public void imp() {
        performence.perform();
        //通过@DeclareParents，为Perform引入了新的方法。
        Encorable encorable = (Encorable) performence;
        encorable.imp();

    }

}
