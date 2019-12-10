package com.person.controller;

import com.person.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 员工的控制
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/11/28/16:53
 */
@RestController
public class EmpController {
    private Logger logger=  LoggerFactory.getLogger(EmpController.class);

    @Autowired(required = true)
    private EmployeeMapper employeeMapper;

    // @RequestMapping("/getEmpId/{id}")
    // @GetMapping
    // public Employee getEmployee (@PathVariable("id") Integer id) {
    //     Employee employee = employeeMapper.getEmpById(id);
    //     if (employee == null) {
    //         logger.error("没有匹配的用户");
    //     }
    //     return employee;
    // }
}
