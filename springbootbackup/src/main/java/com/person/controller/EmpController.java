package com.person.controller;

import com.person.mapper.EmployeeMapper;
import com.person.pojo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("/getEmpId/{id}")
    @GetMapping
    public Employee getEmployee (@PathVariable("id") Integer id) {
        Employee employee = employeeMapper.getEmpById(id);
        if (employee == null) {
            logger.error("没有匹配的用户");
        }
        return employee;
    }

    @RequestMapping("/postEmpId")
    @PostMapping
    public List<Employee> postEmployee (Integer  id) {
        List<Employee> employees = employeeMapper.postEmpById(id);
        System.out.println("集合的长度"+employees.size());
        if (employees.size()<1) {
            logger.info("查询的员工不存在=====");
        }
        for (Employee employee : employees) {
            System.out.println(employee.getdId()+"=="+employee.getEmail());
        }
        return employees;
    }

    @PostMapping("/queyAa")
    public List<Employee> queryAa(String lastName) {

        List<Employee> list = employeeMapper.slurQuery(lastName);
        System.out.println("集合的长度" + list.size());
        if (list.size() < 1) {
            logger.info("通过的模糊查询查询的员工不存在=====");
        }
        for (Employee employee : list) {
            System.out.println(employee.getdId() + "==" + employee.getEmail());
        }
        return list;
    }
}
