package com.person.pojo;

import com.alibaba.druid.support.monitor.annotation.MTable;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

/**
 * 员工实体类
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/11/28/11:06
 */
@Table()
// @TableName("employee")
public class Employee {
    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;
    private String password;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lastName='" + lastName + '\'' + ", gender=" + gender + ", email='" + email + '\'' + ", dId=" + dId + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
