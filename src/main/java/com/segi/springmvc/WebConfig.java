package com.segi.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.IOException;

/**
 * @author chenzx
 * @date 2018-10-09 上午 11:26
 */
@Configuration
@ComponentScan(basePackages = {"com.segi.springmvc"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    //enable()方法，我们要求DispatcherServlet将对静态资源的

    //请求转发到Servlet容器中默认的Servlet上，而不是使用DispatcherServlet本身来处理此
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    /*
     * 限制：
     * ①ContentNegotiatingViewResolver还有一个严重的限制。作为ViewResolver的实现，它只能决定资源该如何渲染到客户端，并没有涉及到客户端要
     * 发送什么样的表述给控制器使用。如果客户端发送JSON或XML的话，那么ContentNegotiatingViewResolver就无法提供帮助了
     * ②ContentNegotiatingViewResolver还有一个相关的小问题，所选中的View会渲染模型（Map格式）给客户端，而不是资源（如json）
     * 因为有这些限制，我通常建议不要使用ContentNegotiatingViewResolver。我更加倾向于使用Spring的消息转换功能来生成资源表述。
     *
     * 1、ContentNegotiatingViewResolver会首先查看URL的文件扩展名。如果URL在结尾处有文件扩展名的话，ContentNegotiatingViewResolver
     * 将会基于该扩展名确定所需的类型。如果扩展名是“.json”的话，那么所需的内容类型必须是“application/json”。如果扩展名是“.xml”，那么客户端
     * 请求的就是“application/xml”。当然，“.html”扩展名表明客户端所需的资源表述为HTML（text/html）。如果根据文件扩展名不能得到任何媒体类型的话，
     * 那就会考虑请求中的Accept头部信息。在这种情况下，Accept头部信息中的值就表明了客户端想要的MIME类型，没有必要再去查找了。最后，如果没有Accept
     * 头部信息，并且扩展名也无法提供帮助的话，ContentNegotiatingViewResolver将会使用“/”作为默认的内容类型，这就意味着客户端必须要接收服务器发送
     * 的任何形式的表述。
     * 2、ContentNegotiatingViewResolver要求其他的视图解析器将逻辑视图名解析为视图。解析得到的每个视图都会放到一个列表中。
     * 这个列表装配完成后，ContentNegotiatingViewResolver会循环客户端请求的所有媒体类型，在候选的视图中查找能够产生对应内容类型的视图。
     * 第一个匹配的视图会用来渲染模型。
     * 3、在大多数场景下，ContentNegotiatingViewResolver会假设客户端需要HTML，如ContentNegotiationManager配置所示。
     * 但是，如果客户端指定了它想要JSON（通过在请求路径上使用“.json”扩展名或Accept头部信息）的话，那么ContentNegotiatingViewResolver
     * 将会查找能够处理JSON视图的视图解析器。
     */
    /*@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }*/

//    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager contentNegotiationManager) {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(contentNegotiationManager);
        return viewResolver;
    }
    /*
     * 4、如果逻辑视图的名称为“spittles”，那么我们所配置的BeanNameViewResolver将会解析spittles()方法中所声明的View。
     * 这是因为bean名称匹配逻辑视图的名称。如果没有匹配的View的话，ContentNegotiatingViewResolver将会采用默认的行为，
     * 将其输出为HTML。
     */

    @Bean
    public ViewResolver irviewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Bean
    public ViewResolver bnViewResolver() {
        return new BeanNameViewResolver();
    }

//    @Bean
    public View spittles() {
        return new MappingJackson2JsonView();
    }

//    @Bean
    public View person() {
        return new MappingJackson2JsonView();
    }

    @Bean
    public MultipartResolver multipartResolver() throws IOException {
//        return new StandardServletMultipartResolver();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("D:\\Users\\Administrator\\IdeaProjects\\Test2\\target\\tomcat\\work\\Tomcat\\localhost\\_"));
        multipartResolver.setMaxUploadSize(1024*1024*10);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }

    /*public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        //指定Tile定义的位置
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles/tiles.xml"});
        //开启刷新功能
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    //    @Bean
    public TilesViewResolver tilesViewResolver() {
        return new TilesViewResolver();
    }*/
}
