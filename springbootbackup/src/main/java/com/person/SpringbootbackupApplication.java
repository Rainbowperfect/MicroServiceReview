package com.person;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.person.mapper")
public class SpringbootbackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbackupApplication.class, args);
    }

}
