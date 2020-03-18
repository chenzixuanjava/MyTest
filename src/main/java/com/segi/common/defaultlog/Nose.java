package com.segi.common.defaultlog;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenzx
 * @date 2019-07-16 上午 10:15
 */
public class Nose {

    private static Logger logger = Logger.getLogger(Nose.class.getName());

    public static void main(String[] args) throws IOException {
//        FileHandler handler = new FileHandler("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\wombat.log");
//        Logger.getLogger(Nose.class.getName()).addHandler(handler);
//        logger.addHandler(handler);
        Logger.getLogger("").setLevel(Level.FINEST);
        logger.fine("开始...");
        try {
            System.out.println("测试打印日志");
//            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.INFO, "发生了异常！", e);
        }
            logger.warning("完成！");
    }
}
