package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.Employee;
import com.atguigu.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/employee", method= RequestMethod.GET)
    public String getAllEmployee(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();
        System.out.println("123");
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    @RequestMapping(value="/employee/{id}", method= RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        System.out.println("delete");
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
