package com.segi.springmvc;

import com.segi.springmvc.init.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/**
 * @author chenzx
 * @date 2018-10-09 上午 11:24
 */
public class MyWebAppInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

    /*@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
    }

    //这种方法加载出来的Filter直接映射在DispatcherServlet的路径上
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter()};
    }*/
}
