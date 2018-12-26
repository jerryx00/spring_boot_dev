package com.neo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neo.entity.User;
import com.neo.entity.eureka.*;
import com.neo.util.EurekaUtil;
import com.neo.util.JacksonUtils;
import com.neo.util.RestTemplateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author xgp
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaThymeleafApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EurekaTests {

    private static final Logger log = LoggerFactory.getLogger(EurekaTests.class);
    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${server.port}")
    private String strPort;

    @Value("${spring.application.name}")
    private String strAppId;

    @Value("${jzt.application.remote.ip}")
    private String strRemoteIp;

    @Value("${jzt.application.remote.port}")
    private String strRemotePort;

    @Test
    public void doRegistert(){
        log.info("[doHeartBeat]...begin to doRegistert");
        String url= EurekaUtil.getRegistertUrl(strRemoteIp, strRemotePort, strAppId);
        //xxpojo是个pojo类，post请求中要放在http request body域中
        String requestBody = EurekaUtil.getPara(strRemoteIp, strRemotePort,strAppId, strPort);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);
        //然后把str转换成JSON再通过getJSONObject()方法获取到里面的result对象，因为我想要的数据都在result里面
        //下面的strToJson只是一个str转JSON的一个共用方法；
        ResponseEntity<String> responseEntity =  restTemplate.postForEntity(url, httpEntity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        boolean isSuccess = status.is2xxSuccessful();
        log.info("[doRegistert]...httpCode: " + status + ", body:" + body);
    }

    @Test
    public void doHeartBeat(){
        log.info("[doHeartBeat]...begin to doHeartBeat");
        String instanceId = EurekaUtil.getInstanceId(strAppId, strPort);
        String heartUrlPrefix= EurekaUtil.getHeartUrlPrefix(strRemoteIp, strRemotePort);
        String heartBeatUrl = EurekaUtil.getHeartUrl(strRemoteIp, strRemotePort, strAppId, instanceId);

        RestTemplateUtil rtu = new RestTemplateUtil(heartBeatUrl);
        ResponseEntity<String> responseEntity = rtu.exchange(heartBeatUrl, HttpMethod.PUT, null);
        if (responseEntity == null) {
            log.info("[doHeartBeat]...responseEntity: " + responseEntity );
        } else {
            HttpStatus status = responseEntity.getStatusCode();
            boolean isSuccess = status.is2xxSuccessful();
            log.info("[doHeartBeat]...result: " + isSuccess);
        }
    }

    //无状态返回，无法判断结果
    @Test
    public void doHeart(){
        String instanceId = EurekaUtil.getInstanceId(strAppId, strPort);
        String heartUrlPrefix= EurekaUtil.getHeartUrlPrefix("127.0.0.1", strRemotePort);
        String heartBeatUrl = EurekaUtil.getHeartUrl("127.0.0.1", strRemotePort, strAppId, instanceId);

        restTemplate.put(heartBeatUrl, null);

//        log.info("[doHeartBeat]...httpCode: " + code + ", body:" + body);
    }



}
