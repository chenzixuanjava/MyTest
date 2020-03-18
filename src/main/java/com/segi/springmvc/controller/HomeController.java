package com.segi.springmvc.controller;

import com.segi.common.clone.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chenzx
 * @date 2018-10-09 下午 12:53
 */
@Controller
@RequestMapping(value = {"/", "homepage", "home"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public void home() {
        //如果没有返回视图名，将会将请求路径去掉"/"作为视图名
        System.out.println("进入hone()");
//        return "home";
    }


}
