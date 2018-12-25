package com.neo;

import com.neo.entity.LoanUser;
import com.neo.entity.LoanUserSimple;
import com.neo.util.JacksonUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * @author Levin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaThymeleafApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateLoanUserSimpleTests {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateLoanUserSimpleTests.class);
    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    private String prefix = "/loan/";


    @Test
    public void test1() throws Exception {
        String url1 = "http://localhost:" + port + prefix;

        // TODO 如果是返回的集合,要用 exchange 而不是 getForEntity ，后者需要自己强转类型
        ResponseEntity<List<LoanUserSimple>> response2 = template.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<LoanUserSimple>>() {
        });
        final List<LoanUserSimple> body1 = response2.getBody();
        log.info("[test1......查询所有LoanUserSimple] - {}\n", body1);

        final List<LoanUserSimple> body = response2.getBody();
        log.info("[test1......查询所有LoanUserSimple] - {}\n", body);
        Long userId = body.get(0).getId();

        String url3 = "http://localhost:" + port + prefix + "{id}";
        ResponseEntity<LoanUserSimple> response3 = template.getForEntity(url3, LoanUserSimple.class, userId);
        log.info("[test1......主键查询LoanUserSimple] - {}\n", response3.getBody());

        String s = template.getForObject(url3, String.class, userId);
        LoanUserSimple lus = JacksonUtils.jsonToBean(s, LoanUserSimple.class);
        log.info("[test1......主键查询JacksonUtils->LoanUserSimple] - {}\n", lus.toString());

        String url2 = "http://localhost:" + port + prefix;


        log.info("[test1......查询所有List<LoanUser>,返回String] - {}\n", s);

    }
}
