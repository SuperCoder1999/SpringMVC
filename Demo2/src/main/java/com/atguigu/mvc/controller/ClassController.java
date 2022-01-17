package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping注解用在类上
 */
@Controller
@RequestMapping("/user")
public class ClassController {
    /**
     * 处理 "/user/success.html 请求
     */
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
