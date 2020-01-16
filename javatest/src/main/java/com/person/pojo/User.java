package com.person.pojo;

/**
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/12/16/17:10
 */

public class User {
    private String userName;
    private Integer age;

    @Override
    public String toString() {
        return "User{" + "userName='" + userName + '\'' + ", age=" + age + '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}