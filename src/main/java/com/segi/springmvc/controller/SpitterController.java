package com.segi.springmvc.controller;

import com.segi.springmvc.exception.ExceptionHandlerExcepiton;
import com.segi.springmvc.model.Person;
import com.segi.springmvc.model.Spitter;
import com.segi.springmvc.service.SpitterReposoty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * @author chenzx
 * @date 2018-10-09 下午 4:00
 */
@Component
//@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterReposoty spitterReposoty;

    public SpitterController() {

    }
//    @Autowired
    public SpitterController(SpitterReposoty spitterReposoty) {
        this.spitterReposoty = spitterReposoty;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(new Spitter());
        return "spitterRegisterForm";
    }

    //Part  jdk的part不需要视图解析器
    @RequestMapping(value = "/registerSub", method = RequestMethod.GET)
    public String processRegisteration(/*@RequestBody *//*Map<String, Object> map*/Person person, /*@Validated Spitter spitter,*/ /*BindingResult bindingResult,*/ Part file/*MultipartFile file*//*@RequestPart byte[] file*/, HttpServletRequest req) throws IOException, ExceptionHandlerExcepiton {
        /*if (bindingResult.hasErrors()) {
            System.out.println("验证不通过");
            return "spitterRegisterForm";
        }*/
        System.out.println(person);
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("age"));
        if (null != file) {
            /*System.out.println(file.getOriginalFilename());
            System.out.println(file.getSize());
            System.out.println(file.getName());
            System.out.println(file.getContentType());
            System.out.println(file.getBytes());
            System.out.println(file.getInputStream());
            file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\upload.jpg"));*/

            //            System.out.println(file.length);

            System.out.println(file.getContentType());
            System.out.println(file.getName());
            Collection<String> headerNames = file.getHeaderNames();
            for (String headerName : headerNames) {
                System.out.println(headerName + ": " + file.getHeader(headerName));
            }
            System.out.println(file.getSize());
            System.out.println(file.getInputStream());
            file.write("C:\\Users\\Administrator\\Desktop\\upload.jpg");
        } else {
            System.out.println(file);
        }
        System.out.println(req.getServletContext().getRealPath("/"));
//        spitterReposoty.save(spitter);
        //当InternalResourceViewResolver看到视图格式中的“redirect:”前缀时，它就知道要将其解析为重定向的规则，而不是视图的名称。
        //当它发现视图格式中以“forward:”作为前缀时，请求将会前往（forward）指定的URL路径，而不再是重定向
//        handlerException();

        return "redirect:/spitter/"/* + spitter.getUsername()*/;
    }

    private void handlerException() throws ExceptionHandlerExcepiton {
        if (true) {
            throw new ExceptionHandlerExcepiton("@ExceptionHandler处理的异常");
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
//        Spitter spitter = spitterReposoty.findByUsername(username);
//        model.addAttribute(spitter);

        return "profile";
    }



}
