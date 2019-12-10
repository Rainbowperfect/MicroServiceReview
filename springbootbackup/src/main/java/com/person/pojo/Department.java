package com.person.pojo;

/**
 * 部门实体类
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/11/28/10:28
 */

public class Department {
    private Integer id;
    private String departmentName;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", departmentName='" + departmentName + '\'' + '}';
    }
}
