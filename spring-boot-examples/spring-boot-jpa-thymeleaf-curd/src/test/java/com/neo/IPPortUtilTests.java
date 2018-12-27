package com.neo;

import com.neo.util.EurekaUtil;
import com.neo.util.IPPortUtil;
import com.neo.util.RestTemplateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.MalformedObjectNameException;

/**
 * @author xgp
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaThymeleafApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IPPortUtilTests {

    private static final Logger log = LoggerFactory.getLogger(IPPortUtilTests.class);

    @Test
    public void getHostInfo(){
        log.info("IP is: " + IPPortUtil.getLocalIP());
        try {
            log.info("Port is: " + IPPortUtil.getLocalPort());
        } catch (MalformedObjectNameException e) {
            log.info("Port error: " + e.getMessage() );
        }
        log.info("Hostname is: " + IPPortUtil.getHostName());


//        log.info("[doHeartBeat]...httpCode: " + code + ", body:" + body);
    }



}
