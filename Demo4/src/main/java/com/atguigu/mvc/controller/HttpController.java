package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HttpController {

    //获取请求体
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody: " + requestBody);
        return "success";
    }

    //获取请求报文
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        //请求报文封装的对象内有各种方法,可以获取请求头/请求体
        System.out.println("requestHeader: " + requestEntity.getHeaders());
        System.out.println("requestBody: " + requestEntity.getBody());
        return "success";
    }

    //ServletAPI向客户端返回 响应
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello, response");
    }

    //ResponseBody向客户端返回 响应
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "responseBody";
    }

    //ResponseBody向客户端返回 响应对象 响应到浏览器是 json字符串
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User(1001, "admin", "123456", 23, "男");
    }
    //ResponseBody向客户端返回 响应对象 响应到浏览器是 json字符串 数组
    @RequestMapping("/testResponseUsers")
    @ResponseBody
    public List<User> testResponseUsers() {
        User u1 = new User(1001, "admin", "123456", 23, "男");
        User u2 = new User(1002, "admin", "123456", 23, "男");
        User u3 = new User(1003, "admin", "123456", 23, "男");
        ArrayList<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }
}
