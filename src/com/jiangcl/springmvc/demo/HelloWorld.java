package com.jiangcl.springmvc.demo;

import com.alibaba.fastjson.JSONObject;
import com.jiangcl.springmvc.entity.UserDomain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
    public String hello(UserDomain userDomain, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date reqDate){
        System.out.println(userDomain.toString());
        System.out.println(reqDate);
        return "hello";
    }

    @RequestMapping("/respInfo")
    @ResponseBody
    public UserDomain returnUserDomain(UserDomain userDomain){
        System.out.println(userDomain);
        return userDomain;
    }

    @RequestMapping("/writeInfo")
    public void returnUserDomain(UserDomain userDomain, HttpServletResponse response) throws IOException {
        System.out.println(userDomain);
        String jsonString = JSONObject.toJSONString(userDomain);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/Json");
        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
    }

    /**
     * @desc 使用RequestBody接收json参数
     * @author jiangcl
     * @date 2020/1/13
     * @param userDomain
     * @return com.jiangcl.springmvc.entity.UserDomain
     */
    @RequestMapping("/respBody")
    @ResponseBody
    public UserDomain responseBody(@RequestBody UserDomain userDomain){
        System.out.println(userDomain);
        return userDomain;
    }
}
