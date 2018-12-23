package com.neo.web;

import com.neo.entity.User;
import com.neo.entity.UserSimple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/u")
public class RestTemplateController {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateController.class);
    @Autowired
    private RestTemplate restTemplate ;

    //    public <T> T getForObject(String url, Class<T> responseType, Object urlVariables) throws RestClientException
//    public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> urlVariables) throws RestClientException
//    public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException
    @GetMapping("/a")
    public void a() {
        String url1 = "http://localhost:8080/users";
        String result1 = restTemplate.getForObject(url1, String.class);
        log.info("[查询所有result1] - {}\n", result1);
    }

    @GetMapping("/b")
    public void b() {
        String url2 = "http://localhost:8080/users/{id}";
        Map<String, String> vars = Collections.singletonMap("id","1");
        String result2 = restTemplate.getForObject(url2, String.class, vars);
        log.info("[查询所有result2] - {}\n", result2);
    }

    @GetMapping("/c")
    public void c() {
        String url1 = "http://localhost:8080/users";
        ResponseEntity<List<UserSimple>> response2 = restTemplate.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserSimple>>() {
        });

        final List<UserSimple> body = response2.getBody();
        log.info("[test2......查询所有] - {}\n", body);
    }

    @GetMapping("/d")
    public void d() {
        String url1 = "http://localhost:8080/users";
        ResponseEntity<List<User>> response2 = restTemplate.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });

        final List<User> body = response2.getBody();
        log.info("[test2......查询所有] - {}\n", body);
    }


    @RequestMapping("/sayhello")
    public String sayHello() {
        int id = 1;
        String url2 = "http://localhost:8080/users/{id}";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url2, String.class, id);
        return responseEntity.getBody();
    }

    @RequestMapping("/sayhello2")
    public String sayHello2() {
        String url2 = "http://localhost:8080/users/{id}";
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url2, String.class, map);
        return responseEntity.getBody();
    }

    @RequestMapping("/us1")
    public String us1() {
        String url2 = "http://localhost:8080/users/1";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url2, String.class);
        String us = responseEntity.getBody();
        return us;
    }

    @RequestMapping("/us2")
    public UserSimple us2() {
        String url2 = "http://localhost:8080/users/1";
        ResponseEntity<UserSimple> responseEntity = restTemplate.getForEntity(url2, UserSimple.class);
        UserSimple us = responseEntity.getBody();
        return us;
    }

}
