package com.neo;

import com.neo.entity.LoanUser;
import com.neo.entity.LoanUserSimple;
import com.neo.entity.User;
import com.neo.entity.UserSimple;
import com.neo.util.JacksonUtils;
import com.neo.util.JsonUtil;
import com.neo.util.JsonUtils;
import org.assertj.core.util.Lists;
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
    public void testJacksonUtils() throws Exception {
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
        log.info("[JacksonUtils......主键查询LoanUserSimple] - {}\n", response3.getBody());

        String url2 = "http://localhost:" + port + prefix;
        String s = template.getForObject(url2, String.class);
        LoanUserSimple lus = JacksonUtils.jsonToBean(s, LoanUserSimple.class);

        log.info("[JacksonUtils......查询所有LoanUser,返回String] - {}\n", lus);
    }

    @Test
    public void testJacksonUtils1() throws Exception {
        String url2 = "http://localhost:" + port + prefix + "{userId}";
        String s = template.getForObject(url2, String.class, 1001);
        log.info("[testJacksonUtils1......查询单个LoanUser String] - {}\n", s);
        LoanUserSimple lus = JacksonUtils.jsonToBean(s, LoanUserSimple.class);
        log.info("[testJacksonUtils1......JacksonUtils->查询单个LoanUser,转为LoanUserSimple] - {}\n", lus);

        s = JacksonUtils.toPrettyString(s);
        log.info("[testJacksonUtils1......toPrettyString] - {}\n", s);
    }


    @Test
    public void testJacksonUtilsList() throws Exception {
        String url1 = "http://localhost:" + port + prefix;
        String s = template.getForObject(url1, String.class);

        log.info("[testJacksonUtilsList......String] - {}\n", s);
        List<LoanUser> userListObj = JsonUtil.string2Obj(s, new TypeReference<List<LoanUser>>() {});
        log.info("[testJacksonUtilsList.....LoanUser List] - {}\n", userListObj.toString());

        List<LoanUserSimple> userListObj1 = JsonUtil.string2Obj(s, new TypeReference<List<LoanUserSimple>>() {});
        log.info("[testJacksonUtilsList.....LoanUserSimple List] - {}\n", userListObj1.toString());

        List<LoanUserSimple> userListObj2 = JsonUtil.string2Obj(s,List.class,User.class);
        log.info("[testJsonUtilString2Obj.....LoanUserSimple List] - {}\n", userListObj2.toString());
    }




    @Test
    public void testJsonUtils() throws Exception {
        String url2 = "http://localhost:" + port + prefix + "{userId}";
        String s = template.getForObject(url2, String.class, 1001);
        log.info("[JsonUtils......查询单个LoanUser,String] - {}\n", s);

        LoanUserSimple l = JsonUtils.jsonToPojo(s, LoanUserSimple.class);
        log.info("[JsonUtils.....JsonUtil->.查询单个LoanUser,转为LoanUserSimple] - {}\n", l);
    }


    @Test
    public void testJsonUtil() throws Exception {
        String url2 = "http://localhost:" + port + prefix + "{userId}";
        String s = template.getForObject(url2, String.class, 1001);
        log.info("[test3......查询单个LoanUser,String] - {}\n", s);

        LoanUserSimple l = JsonUtil.string2Obj(s, LoanUserSimple.class);
        log.info("[test3.....JsonUtil->.查询单个LoanUser,转为LoanUserSimple] - {}\n", l);
    }

    @Test
    public void testJsonUtilString2Obj() {
        LoanUserSimple u1 = new LoanUserSimple();
        u1.setName("aaa");
        u1.setId(1);

        LoanUserSimple u2 = new LoanUserSimple();
        u2.setName("bbb");u2.setId(2);
        List<LoanUserSimple> userList = Lists.newArrayList();

        userList.add(u1);
        userList.add(u2);
        String userListStr = JsonUtil.obj2StringPretty(userList);
        List<LoanUserSimple> userListObj = JsonUtil.string2Obj(userListStr, new TypeReference<List<LoanUserSimple>>() {});
        log.info("[testJsonUtilString2Obj.....JsonUtil.string2Obj-1] - {}\n", userListObj.toString());

        List<User> userListObj2 = JsonUtil.string2Obj(userListStr,List.class,User.class);
        log.info("[testJsonUtilString2Obj.....JsonUtil.string2Obj-2] - {}\n", userListObj2.toString());

    }



}
