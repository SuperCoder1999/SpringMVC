package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC的视图
 */
@Controller
public class ViewController {
    /**
     * 如果控制器方法设置的视图名称没有任何前缀后缀,得到ThymeleafView.通过转发的方式实现跳转到内部资源
     */
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    /**
     * 添加"forward"前缀,得到InternalResourceView视图 转发到其他请求
     */
    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    /**
     * 添加"redirect"前缀,得到RedirectView视图 重定向到其他请求
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }

    /**
     * 添加"redirect"前缀,得到RedirectView视图 重定向到 外部资源
     */
    @RequestMapping("/testRedirectUrl")
    public String testRedirectUrl() {
        return "redirect:http://www.baidu.com";
    }
}
