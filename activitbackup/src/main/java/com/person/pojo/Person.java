package com.person.pojo;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 6757393795687480331L;

    //编号

    private Integer id;

    private  String name;

    private String education;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", education='" + education + '\'' + '}';
    }
}
