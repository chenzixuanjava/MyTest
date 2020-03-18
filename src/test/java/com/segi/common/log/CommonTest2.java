package com.segi.common.log;

import org.junit.Test;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.Calendar;
import java.util.logging.*;

/**
 * @author chenzx
 * @date 2018-09-29 上午 10:19
 */
public class CommonTest2 {

    @Test
    public void testLogging() {
        Logger logger = Logger.getLogger("a");
        Logger logger1 = Logger.getLogger("a");
        Logger logger2 = Logger.getLogger("a.b");
        System.out.println(logger == logger1);
        logger.setLevel(Level.INFO);
//        logger2.setLevel(Level.WARNING);
        logger.info("开始");
        logger2.info("开始2");
        System.out.println("helloworld");
        logger.info("结束");
        logger2.info("结束2");
    }

    @Test
    public void testHandler() throws IOException {
        Logger logger = Logger.getLogger("a");
        Logger logger1 = Logger.getLogger("a");
        Logger logger2 = Logger.getLogger("a.b");
        System.out.println(logger == logger1);
//        logger.setLevel(Level.INFO);

        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + ": " + record.getMessage() + "\n";
            }
        };
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(formatter);
        logger.addHandler(consoleHandler);
        FileHandler fileHandler = new FileHandler("C:\\Users\\Administrator\\Desktop\\test.log");
        fileHandler.setLevel(Level.INFO);
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        logger.info("a");
        logger.fine("afine");
        logger2.info("a.b");
        logger2.fine("a.bfine");
    }

    @Test
    public void test() throws Exception {
        System.setProperty("java.util.logging.config.file", "logging.properties");
        //①logger名字与properties总的名字匹配，根据配置文件上的<hanlder>.level来指定级别,
        //但是受到<logger名字>.level的限制（先找代码logger.setLevel（）-->代码没指定，找properties文件的<logger名字>.level）
        //如果handler没有指定级别，按默认的级别来
        //②名字不匹配，就得按照代码里的handler来指定lever了，配置文件里的level不起效果。
        Logger logger = Logger.getLogger("aa");
        logger.setLevel(Level.ALL);
        //这里的handler跟配置文件里的level是独立的。格式是按照配置文件里来的。
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINER);
        logger.addHandler(consoleHandler);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void testFormat() {
        Calendar c = Calendar.getInstance();
        //%[argument_index$][flags][width]conversion
        c.set(1993, 3, 3);
        String s = String.format("Duke's Birthday: %1$tm,%<td,%<tY", c);
        System.out.println(s);

    }

}
