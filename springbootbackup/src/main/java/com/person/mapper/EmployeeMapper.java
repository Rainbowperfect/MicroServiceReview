package com.person.mapper;

import com.person.pojo.Employee;

import java.util.List;

/**
 * employee的增删改
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/11/28/15:14
 */
public interface EmployeeMapper {
    Employee getEmpById(Integer id);

    Employee getLogin(String username, String password);

    List<Employee> postEmpById(Integer id);

    List<Employee> slurQuery(String lastName);
}
