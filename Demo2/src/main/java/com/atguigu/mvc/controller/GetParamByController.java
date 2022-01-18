package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * 获取请求参数
 */
@Controller
public class GetParamByController {
    /**
     * 用于测试获取参数的网页
     */
    @RequestMapping("/param")
    public String param(){
        return "test_getParamByContoller";
    }

    /**
     * 用于在本次会话 创建cookie
     */
    @RequestMapping("/createCookie")
    public String createCookie(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "success";
    }

    /**
     * 原始方法,ServletAPI.其实也借用了MVC的接口
     */
    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    /**
     * 控制器方法的具体形参,获取请求参数
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password, String[] hobby){
        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        return "success";
    }
    /**
     * 控制器方法的具体形参,获取请求参数,用RequestParam注解对请求参数进行匹配
     */
    @RequestMapping("/testParam2")
    public String testParam2(
            @RequestParam(value = "user_name", required = false, defaultValue = "root") String username,
            String password,
            String[] hobby){
        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        return "success";
    }

    /**
     * 控制方法获取 请求头 Header
     */
    @RequestMapping("/testHeader")
    public String testHeader(
            @RequestHeader(value = "sayHaha", required = true, defaultValue = "haha") String host
    ){
        System.out.println("value='sayHaha':"+host);
        return "success";
    }

    /**
     * 控制方法获取 请求头 Cookie
     */
    @RequestMapping("/testCookie")
    public String testCookie(
            @CookieValue("JSESSIONID") String JSESSIONID
    ){
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    /**
     * 使用实体类接收请求参数,直接封装成对象实例
     */
    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user.toString());
        return "success";
    }
}
