package com.person.controller;

import com.person.mapper.EmployeeMapper;
import com.person.pojo.Employee;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 登录控制层
 * @author RootAdmin/RawPerfect
 * @version v1.0
 * @create 2019/12/3/22:20
 */

@Controller
public class LoginController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String getLogin( String username,  String password, Map<String,Object> map)
    {

        Employee employee = employeeMapper.getLogin("username", "password");
            System.out.println("employee:"+employee);
        // if (!StringUtils.isEmpty("username") && !StringUtils.isEmpty("password")) {
        //     try {
        //
        //         // Employee employee = employeeMapper.getLogin("username", "password");
        //
        //         if (employee != null) {
        //             System.out.println(employee);
        //             // return "redirect:/main.html";
        //             return "dashboard";
        //         }
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //         map.put("msg","用户不存在");
        //     }
        // }
        return "dashboard";
    }
}
