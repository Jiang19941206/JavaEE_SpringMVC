package com.jiangcl.springmvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jiangcl
 * @date 2019/12/24
 * @desc spring MVC hello world
 */

@Controller
public class HelloWorld {

    @RequestMapping(value = "/hello",params = {"userName","age!=10","!address"},headers = {})
    public String helloWorld(@RequestParam("userName") String userName, int age){
        System.out.println("hello world");
        System.out.println(userName);
        System.out.println(age);
        return "hello";
    }

    @RequestMapping("/getMethod")
    public String getMethod(String userName){
        System.out.println("getMethod");
        return "hello";
    }

    /**
     * http://localhost:8080/userInfo?userName=jiangcl&password=123456&age=22&address.city=成都&address.province=四川
     * @param userDomain
     * @return
     */
    @RequestMapping("/userInfo")
    public String hello(UserDomain userDomain){
        System.out.println(userDomain.toString());
        return "hello";
    }
}
