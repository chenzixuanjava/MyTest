package com.segi.log.log4j;

import org.apache.log4j.Logger;

/**
 * @author chenzx
 * @date 2019-07-18 上午 8:41
 */
public class Log4jTest {


    private static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {

        /*
         * 1.得到记录器使用Log4j，第一步就是获取日志记录器，这个记录器将负责控制日志信息。其语法为：
         * public static Logger getLogger( String name)
         * 通过指定的名字获得记录器，如果必要的话，则为这个名字创建一个新的记录器。Name一般取本类的名字，比如：
         * static Logger logger = Logger.getLogger ( ServerWithLog4j.class.getName () )
         * */

        /*
        * 2.读取配置文件
        * 当获得了日志记录器之后，第二步将配置Log4j环境，其语法为：
        * BasicConfigurator.configure ()： 自动快速地使用缺省Log4j环境。格式：%r [%t] %p %c %x - %m%n    例如：0 [main] DEBUG com.segi.log.log4j.Log4jTest  - This is debug message.
        * PropertyConfigurator.configure ( String configFilename) ：读取使用Java的特性文件编写的配置文件。
        * DOMConfigurator.configure ( String filename ) ：读取XML形式的配置文件。
        * 经测试：log2j.propertes和log4j.xml在根类路径下都能自动识别。如果此时再
        * */
        //PropertyConfigurator和DOMConfigurator同时开启采用最后一个
//        DOMConfigurator.configure("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\properties\\log4j.xml");
        //此配置开启，覆盖不了另外两项配置方式。
//        BasicConfigurator.configure();
//        PropertyConfigurator.configure("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\properties\\log4j.properties");
        /*
        * 3.插入记录信息（格式化日志信息）
        * 当上两个必要步骤执行完毕，您就可以轻松地使用不同优先级别的日志记录语句插入到您想记录日志的任何地方，其语法如下：
        * Logger.debug ( Object message ) ;
        * Logger.info ( Object message ) ;
        * Logger.warn ( Object message ) ;
        * Logger.error ( Object message ) ;
        * */

        /*
        * 2.3、日志级别
        * 每个Logger都被了一个日志级别（log level），用来控制日志信息的输出。日志级别从高到低分为：
        * A：off 最高等级，用于关闭所有日志记录。
        * B：fatal 指出每个严重的错误事件将会导致应用程序的退出。
        * C：error 指出虽然发生错误事件，但仍然不影响系统的继续运行。
        * D：warm 表明会出现潜在的错误情形。
        * E：info 一般和在粗粒度级别上，强调应用程序的运行全程。
        * F：debug 一般用于细粒度级别上，对调试应用程序非常有帮助。
        * G：all 最低等级，用于打开所有日志记录。
        *
        * 上面这些级别是定义在org.apache.log4j.Level类中。Log4j只建议使用4个级别，优先级从高到低分别是error,warn,info和debug。
        * 通过使用日志级别，可以控制应用程序中相应级别日志信息的输出。例如，如果使用了info级别，则应用程序中所有低于info级别的日志信息
        * (如debug)将不会被打印出来。
        * */

        // 记录debug级别的信息
        LOGGER.debug("This is debug message.");
        // 记录info级别的信息
        LOGGER.info("This is info message.");
        // 记录error级别的信息
        LOGGER.error("This is error message.");
    }
}
