package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建请求控制器
 */
@Controller //就是一个普通类.而这个注解也是 使之能被组件扫描.放入IOC容器中
public class HelloController {
    //在请求控制器中创建转发请求的方法

    /**
     * 访问http://localhost:8080/Demo1/时, 进行的处理
     * RequestMapping注解：处理请求和控制器方法之间的映射关系
     * RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径localhost:8080/springMVC/
     * 其中,只添加value属性时,可以省略value属性名
     * @return 当访问"/"路径时,返回的页面是 前缀 +return字符串+后缀的文件
     */
    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }

    /**
     * http://localhost:8080/Demo1/hello时,进行的处理
     */
    @RequestMapping("/hello")
    public String toTarget() {
        //设置视图名称
        return "target";
    }

    /**
     * RequestMapping用于.html结尾的请求 http://localhost:8080/Demo1/url.html
     */
    @RequestMapping("/url.html")
    public String toTarget2() {
        System.out.println("http://localhost:8080/Demo1/url.html");
        //设置视图名称
        return "url";
    }
}
