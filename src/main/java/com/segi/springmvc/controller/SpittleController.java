package com.segi.springmvc.controller;

import com.google.common.collect.Lists;
import com.segi.springmvc.model.Person;
import com.segi.springmvc.model.Spittle;
import com.segi.springmvc.service.SpittleReposoty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-09 下午 3:00
 */
@Controller
public class SpittleController {

    private SpittleReposoty spittleReposoty;

    public SpittleController() {
    }

    //    @Autowired
    public SpittleController(SpittleReposoty spittleReposoty) {
        this.spittleReposoty = spittleReposoty;
    }

    //如果路径变量名称与参数名称一致，@PathVariable里的value值可以省略
    @RequestMapping(value = "/spittle/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable Long spittleId, Model model) {
//        List<Spittle> spittles = spittleReposoty.findSpittles(Long.MAX_VALUE, 20);
        /*Spittle spittle = spittleReposoty.findOne(spittleId);
        model.addAttribute(spittle);*/
        return "spittles";
    }

    /*
     * @ResponseBody注解会告知Spring，我们要将返回的对象作为资源发送给客户端，并将其转换为客户端可接受的表述形式。
     * 更具体地讲，DispatcherServlet将会考虑到请求中Accept头部信息，并查找能够为客户端提供所需表述形式的消息转换器。
     * 举例来讲，假设客户端的Accept头部信息表明它接受“application/json”，并且JacksonJSON库位于应用的类路径下，
     * 那么将会选择MappingJacksonHttpMessage-Converter或MappingJackson2HttpMessageConverter（这取决于类路径下
     * 是哪个版本的Jackson）。消息转换器会将控制器返回的Spittle列表转换为JSON文档，并将其写入到响应体中。
     */
    @RequestMapping(value = "/person", method = RequestMethod.POST/*, consumes = {"application/json"}*/)
    @ResponseBody()
//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    //@RequestBody 可以接受：Java Type, Map, 阿里JsonObject
    public/* List<Person>*/ResponseEntity<Person> person(@RequestBody Person person, UriComponentsBuilder ucs) {
//        System.out.println(person);
        System.out.println(person);
        HttpHeaders httpHeaders = new HttpHeaders();
//        URI uri = URI.create("localhost:8888/person/" + person.getAge());
        URI uri = ucs.path("/person")
                .path(person.getAge().toString())
                .build()
                .toUri();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<Person>(person, httpHeaders, HttpStatus.CREATED)/*Lists.newArrayList(person)*/;
    }

    @ResponseBody
    @RequestMapping(value = "/spittles", method = RequestMethod.POST)
    public List<Spittle> spittles(@RequestParam(value = "message",defaultValue = "10000")String message,
                           @RequestParam(value = "count", defaultValue = "20")Integer count) {
        List<Spittle> spittles = Lists.newArrayList(new Spittle(message + "1", new Date()), new Spittle(message + "2", new Date()));
        System.out.println(message);
        System.out.println(count);
        System.out.println(spittles);
        return spittles;
    }

    @RequestMapping("/person/{id}")
    public String restTemplate(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForLocation("http://localhost:8888/person", new Person(2, "chen", 24)).toString();
    }

    @RequestMapping(value = "/findPersonById/{id}")
    @ResponseBody
    public Person findPersonById(Integer id) {
        return new Person(id);
    }

}


