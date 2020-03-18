package com.segi.springmvc;

import com.segi.springmvc.init.MyFilter;
import com.segi.springmvc.init.MyListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * @author chenzx
 * @date 2018-10-11 下午 12:59
 */
public class MyWebAppInitializer2 implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", dispatcherServlet);
        myServlet.addMapping("/");
        //最后一个参数，如果文件大小达到了一个指定最大容量（以字节为单位），将会写入到临时文件路径中。默认值为0，也就是所有上传的文件都会写入到磁盘上
        myServlet.setMultipartConfig(new MultipartConfigElement("D:\\Users\\Administrator\\IdeaProjects\\Test2\\target\\tomcat\\work\\Tomcat\\localhost\\_", 1024*1024*10, 1024*1024*12, 0));

        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        myFilter.addMappingForUrlPatterns(null, false, "/");

        servletContext.addListener(MyListener.class);
    }
}
