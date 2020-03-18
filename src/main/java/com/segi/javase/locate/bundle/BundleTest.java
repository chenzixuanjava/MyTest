package com.segi.javase.locate.bundle;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author chenzx
 * @date 2019-07-18 下午 3:35
 */
public class BundleTest {

    public static void main(String[] args) throws IOException {
        /*
        * 寻找包bundle,文件名myRes_zh_CN.properties;
        * */

        /*
        * new Locale(“zh”, “CN”)提供本地化信息。
        * 程序会首先在classpath下寻找my_zh_CN.properties文件，
        * 若my_zh_CN.properties文件不存在，则取找my_zh.properties，
        * 如还是不存在，继续寻找my.properties,
        * 若都找不到就抛出异常。
        * */
        ResourceBundle bundle = ResourceBundle.getBundle("bundle.myRes", new Locale("zh", "CN"));
        String nameValue = bundle.getString("name");
        System.out.println(nameValue);

        bundle = ResourceBundle.getBundle("bundle.myRes", Locale.US);
        nameValue = bundle.getString("name");
        System.out.println(nameValue);

        bundle = ResourceBundle.getBundle("bundle.myRes", Locale.getDefault());
        nameValue = bundle.getString("name");
        System.out.println(nameValue);

        /*
        * 由于我们未定义GERMAN属性文件，这时ResourceBundle为我们提供了一个fallback（也就是一个备用方案），
        * 这个备用方案就是根据当前系统的语言环境来得到的本地化信息。所以若是找不到GERMAN的，之后就会去找CHINA了，
        * 所以找到了res_zh_CH.properties这个资源包
        * */
        bundle = ResourceBundle.getBundle("bundle.myRes", Locale.GERMAN);
        nameValue = bundle.getString("name");
        System.out.println(nameValue);

        for (String key : bundle.keySet()) {
            System.out.println(key);
        }

        /*
        * PropertyResourceBundle从流中指定属性文件
        * */
        bundle = new PropertyResourceBundle(new BufferedInputStream(new FileInputStream("D:\\Users\\Administrator\\IdeaProjects\\my_test\\Test2\\src\\main\\resources\\log4j.properties")));
        for (String key : bundle.keySet()) {
            System.out.println(key);
        }
    }
}
