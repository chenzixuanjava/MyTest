package com.segi.spring.IOC;

import com.segi.spring.IOC.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenzx
 * @date 2018-09-30 上午 10:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(/*classes = {CDPlayerConfig.class, CDAndCDPlayerConfig.class}, */locations = {"classpath:spring/applicationContext-common.xml", "classpath:spring/applicationContext-config.xml"})

public class CommonTest {

    @Autowired
    CompactDisc compactDisc;

    @Autowired
    MediaPlayer mediaPlayer;

    @Autowired
    DiscPlayer discPlayer;

    @Test
    public void mock() {
        Man man = Mockito.mock(Man.class);
        Person person = new Person(man);
        person.manEea();
        person.manEea();
        Mockito.verify(man, Mockito.times(2)).eat();
    }

    @Test
    public void testDI1() {
        Assert.assertNotNull(compactDisc);
    }

    @Test
    public void testDI2() {
        Assert.assertNotNull(mediaPlayer);
        mediaPlayer.play();
    }

    @Test
    public void TestJavaConfigImport() {
        discPlayer.play();
    }

}
