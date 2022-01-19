package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    /**
     * 没有前后缀,也是生成InternalResourceView.再转发访问内部资源
     */
    @RequestMapping("/testJsp")
    public String success() {
        return "success";
    }

    /**
     * 有forward前缀,也只能转发访问其他 "需要处理的请求",而不能直接访问资源
     */
    @RequestMapping("/testJspForward")
    public String testJspForward() {
        return "forward:/testJsp";
    }

    /**
     * 添加"redirect"前缀,得到RedirectView视图 重定向到其他请求
     */
    @RequestMapping("/testJspRedirect")
    public String testRedirect() {
        return "redirect:/testJsp";
    }

    /**
     * 添加"redirect"前缀,得到RedirectView视图 重定向到 外部资源
     */
    @RequestMapping("/testJspRedirectUrl")
    public String testRedirectUrl() {
        return "redirect:http://www.baidu.com";
    }
}
