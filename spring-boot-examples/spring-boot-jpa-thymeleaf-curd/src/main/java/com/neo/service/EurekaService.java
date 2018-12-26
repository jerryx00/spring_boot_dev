package com.neo.service;

import com.neo.util.EurekaUtil;
import com.neo.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EurekaService {

    private static final Logger log = LoggerFactory.getLogger(EurekaService.class);

    @Autowired
    private RestTemplate restTemplate;

    public boolean doRegistert(String strRemoteIp,String strRemotePort, String strAppId, String strPort){
        String url= EurekaUtil.getRegistertUrl(strRemoteIp, strRemotePort, strAppId);
        //xxpojo是个pojo类，post请求中要放在http request body域中
        String requestBody = EurekaUtil.getPara(strRemoteIp,strRemotePort,strAppId, strPort);
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
        return isSuccess;
    }

    public void doHeartBeat(String strRemoteIp,String strRemotePort, String strAppId, String strPort){
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
}
