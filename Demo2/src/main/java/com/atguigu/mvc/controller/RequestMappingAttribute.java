package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingAttribute {
    /**
     * value字符串数组 处理多个 请求
     */
    @RequestMapping(value = {"/test", "/testRequestMapping"})
    public String value() {
        return "value";
    }

    /**
     * method属性,通过请求方式进行匹配
     */
    @RequestMapping(value = {"/method"},
    method = {RequestMethod.GET})
    public String method() {
        return "success";
    }
    /**
     * 使用GetMapping注解代替RequestMapping,并将method属性设置为get
     */
    @GetMapping(
            value = {"/GetMapping"}
    )
    public String getMapping() {
        return "success";
    }

    /**
     * params参数必须都得匹配成功
     */
    @RequestMapping(value = {"/params"} ,
            params = {"username", "!url", "password!=1234", "local=beijing"}
    )
    public String params() {
        return "success";
    }

    /**
     * headers属性,和params几乎一致
     */
    @RequestMapping(value="/headers",
    //headers={"Host!=localhost:8080"} 报错404
    headers={"Host=localhost:8080"})
    public String headers() {
        return "success";
    }
}
