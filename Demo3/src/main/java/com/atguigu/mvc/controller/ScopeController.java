package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * SpringMVC操作四大域中的数据
 */
@Controller
public class ScopeController {
    /**
     * 通过ServletAPI操作域对象Request
     */
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("RequestScope", "hello, servletAPI");
        Enumeration<String> enumeration = request.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        return "success";
    }

    /**
     * 通过ModelAndView向request域对象共享数据
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScopeByModelAndView", "hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    /**
     * 通过Model向向request域对象共享数据
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        //处理模型数据，即向请求域request共享数据
        model.addAttribute("RequestScopeByModel", "hello,Model");
        return "success";
    }

    /**
     * 通过Map向向request域对象共享数据
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        //处理模型数据，即向请求域request共享数据
        map.put("RequestScopeByMap", "Hello, Map");
        return "success";
    }

    /**
     * 通过ModelMap向向request域对象共享数据
     */
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        //处理模型数据，即向请求域request共享数据
        modelMap.addAttribute("RequestScopeByModelMap", "Hello, ModelMap");
        return "success";
    }

    /**
     * 通过原生ServletAPI向session域共享数据
     */
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("SessionScope", "hello, session");
        return "success";
    }

    /**
     * 通过原生ServletAPI向ServletContext域共享数据
     */
    @RequestMapping("/testServletContext")
    public String testServletContext(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("application", "hello, application");
        return "success";
    }
}
