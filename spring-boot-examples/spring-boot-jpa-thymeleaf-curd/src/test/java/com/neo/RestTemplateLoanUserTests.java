package com.neo;

import com.neo.entity.LoanUser;
import com.neo.entity.LoanUserSimple;
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
public class RestTemplateLoanUserTests {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateLoanUserTests.class);
    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    private String prefix = "/loan/";


    @Test
    public void test1() throws Exception {
        String url1 = "http://localhost:" + port + prefix;
        // TODO 如果是返回的集合,要用 exchange 而不是 getForEntity ，后者需要自己强转类型
        ResponseEntity<List<LoanUser>> response2 = template.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<LoanUser>>() {
        });
        final List<LoanUser> body1 = response2.getBody();
        log.info("[test2......查询所有] - [{}]\n", body1);

        String url2 = "http://localhost:" + port + prefix;
        String s = template.getForObject(url2, String.class);
        log.info("[test2......查询所有,返回String] - {}\n", s);

        final List<LoanUser> body = response2.getBody();
        log.info("[test2......查询所有] - [{}]\n", body);
        Long userId = body.get(1000).getId();

        String url3 = "http://localhost:" + port + prefix + "{id}";
        ResponseEntity<LoanUser> response3 = template.getForEntity(url3, LoanUser.class, userId);
        log.info("[test2......主键查询] - [{}]\n", response3.getBody());

    }
}
