package com.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目的初始创建，初始第一步
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/11/22/0:25
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getHello() {
        return  "Hello SpringBoot";
    }
}
