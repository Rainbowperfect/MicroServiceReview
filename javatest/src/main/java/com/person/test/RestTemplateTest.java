package com.person.test;

import com.person.pojo.User;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/12/16/17:07
 */

public class RestTemplateTest {

    @Test
    public void templatePost(){
        RestTemplate template = new RestTemplate();
        User user = new User();
        user.setUserName("测试名字");
        user.setAge(12);
        URI build = UriComponentsBuilder.fromUriString("http://www.baidu.com").build().toUri();
        ResponseEntity<String> entity = template.postForEntity(build, user, String.class);
        System.out.println("返回的实体"+entity);
    }
}
