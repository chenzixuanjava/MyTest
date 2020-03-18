package com.segi.spring.AOP;

import com.segi.spring.AOP.model.xml.CompactDisc;
import com.segi.spring.AOP.model.xml.Encorable;
import com.segi.spring.AOP.model.xml.Performence;
import com.segi.spring.AOP.model.xml.PlayTrackCounter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-10-09 上午 9:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-aop.xml"})
public class XMLAOPTest {
    @Autowired
    Performence performence;

    @Autowired
    PlayTrackCounter playTrackCounter;

    @Autowired
    CompactDisc compactDisc;

    @Test
    public void test1() {
        performence.perform();
    }

    @Test
    public void test2() {
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
    public void test3() {
        performence.perform();
        System.out.println("============");
        Encorable encorable = (Encorable) performence;
        encorable.imp();

    }
}
