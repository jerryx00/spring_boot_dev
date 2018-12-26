package com.neo.web;

import com.neo.entity.eureka.*;
import com.neo.service.EurekaService;
import com.neo.util.EurekaUtil;
import com.neo.util.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/e")
public class EurekaController {

    private static final Logger log = LoggerFactory.getLogger(EurekaController.class);

    @Value("${server.port}")
    private String strPort;

    @Value("${spring.application.name}")
    private String strAppId;

    @Value("${jzt.application.remote.ip}")
    private String strRemoteIp;

    @Value("${jzt.application.remote.port}")
    private String strRemotePort;

    @Autowired
    EurekaService eurekaService;





    }
