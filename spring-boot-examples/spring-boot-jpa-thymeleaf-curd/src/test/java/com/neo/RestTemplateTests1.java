package com.neo;

import com.neo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Levin
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaThymeleafApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTests1 {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateTests1.class);
    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @Test
    public void test1() throws Exception {
        String url1 = "http://localhost:" + port + "/users";
        template.postForEntity(url1, new User("user1", "pass1"), Integer.class);
        log.info("[添加用户成功]\n");
        // TODO 如果是返回的集合,要用 exchange 而不是 getForEntity ，后者需要自己强转类型
        String url2 = "http://localhost:" + port + "/users";
        ResponseEntity<List<User>> response2 = template.exchange(url2, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        final List<User> body = response2.getBody();
        log.info("[查询所有] - [{}]\n", body);
        Long userId = body.get(0).getId();

        String url3 = "http://localhost:" + port + "/users/{id}";
        ResponseEntity<User> response3 = template.getForEntity(url3, User.class, userId);
        log.info("[主键查询] - [{}]\n", response3.getBody());

        String url4 = "http://localhost:" + port + "/users/{id}";
        template.put(url4, new User("user11", "pass11"), userId);
        log.info("[修改用户成功]\n");

        String url5 = "http://localhost:" + port + "/users/{id}";
        template.delete(url5, userId);
        log.info("[删除用户成功]");
    }
}
