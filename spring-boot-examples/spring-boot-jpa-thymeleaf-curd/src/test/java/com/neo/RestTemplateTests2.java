package com.neo;

import com.neo.entity.User;
import com.neo.entity.UserSimple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RestTemplateTests2 {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateTests2.class);
    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port ;

    private String prefix = "/loan/";


    @Test
    public void test1() throws Exception {
        String url1 = "http://localhost:" + port + prefix;

        // TODO 如果是返回的集合,要用 exchange 而不是 getForEntity ，后者需要自己强转类型
        ResponseEntity<List<UserSimple>> response2 = template.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserSimple>>() {
        });
        final List<UserSimple> body = response2.getBody();
        log.info("[查询所有] - {}\n", body);

        final List<UserSimple> body1 = response2.getBody();
        log.info("[test2......查询rowid=1] - {}\n", body);
        Long userId = body1.get(0).getId();

        String url3 = "http://localhost:" + port + prefix + "{id}";
        ResponseEntity<UserSimple> response3 = template.getForEntity(url3, UserSimple.class, userId);
        log.info("[test2......主键rowid="+ userId +"] - [{}]\n", response3.getBody());
    }

    @Test
    public void test2() throws Exception {
        String url1 = "http://localhost:" + port + "/users";
        ResponseEntity<Long> response = template.postForEntity(url1, new User("user1", "pass1"), Long.class);
        log.info("[test2......添加用户成功]\n");
        // TODO 如果是返回的集合,要用 exchange 而不是 getForEntity ，后者需要自己强转类型
        ResponseEntity<List<UserSimple>> response2 = template.exchange("http://localhost:" + port + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserSimple>>() {
        });
        String url2 = "http://localhost:" + port + "/users";
        String s = template.getForObject(url2, String.class);
        log.info("[test2......查询所有,返回String] - {}\n", s);

        final List<UserSimple> body = response2.getBody();
        log.info("[test2......查询所有] - [{}]\n", body);
        Long userId = body.get(0).getId();

        String url3 = "http://localhost:" + port + "/users/{id}";
        ResponseEntity<UserSimple> response3 = template.getForEntity(url3, UserSimple.class, userId);
        log.info("[test2......主键查询] - [{}]\n", response3.getBody());

        String url4 = "http://localhost:" + port + "/users/{id}";
        template.delete(url4, userId);
        log.info("[test2......删除用户成功]");
    }
}
