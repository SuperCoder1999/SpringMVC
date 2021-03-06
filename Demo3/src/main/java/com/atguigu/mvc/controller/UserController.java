package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Restful的实现
 */
@Controller
public class UserController {
    /**
     * 使用RESTFul模拟用户资源的增删改查
     * /user    GET     查询所有用户信息
     * /user/1    GET     根据用户id查询用户信息
     * /user    POST     添加用户信息
     * /user/1    DELETE     删除用户信息
     * /user    PUT     修改用户信息
     */

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public String getUserById(String id) {
        System.out.println("根据用户id查询用户信息: " + id);
        return "success";
    }

    //因为这里提交的是表单信息,拼接方式还是 ? ,所以不能用占位符
    @RequestMapping(value="/user", method= RequestMethod.POST)
    public String addUser(String username, String password) {
        System.out.println("添加用户信息:" + username + "  " + password);
        return "success";
    }

    //因为这里提交的是表单信息,拼接方式还是 ? ,所以不能用占位符
    @RequestMapping(value="/user", method= RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息:" + username + "  " + password);
        return "success";
    }

    //删除的客户端提交功能实现 有些困难.暂时不演示
    /*@RequestMapping(value="/user/{id}", method= RequestMethod.DELETE)
    public String deleteUserById(String id) {
        System.out.println("删除用户信息: " + id);
        return "success";
    }*/
}
