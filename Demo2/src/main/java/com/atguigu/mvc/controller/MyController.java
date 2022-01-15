package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    /**
     * 处理 "/"请求
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
