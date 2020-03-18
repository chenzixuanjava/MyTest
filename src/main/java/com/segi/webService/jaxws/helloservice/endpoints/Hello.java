package com.segi.webService.jaxws.helloservice.endpoints;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author chenzx
 * @date 2019-07-03 上午 11:56
 */
@WebService
public class Hello {

    private String message = new String("hello, ");

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
