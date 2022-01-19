package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    //使用 标签实现视图控制器 代替简单的控制器方法
    /*@RequestMapping("/")
    public String index() {
        return "index";
    }*/

    @RequestMapping("/test_view")
    public String test_view() {
        return "test_view";
    }
}
