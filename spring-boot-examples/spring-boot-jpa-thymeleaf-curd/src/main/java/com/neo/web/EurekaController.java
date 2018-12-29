package com.neo.web;

import com.neo.entity.ResultModel;
import com.neo.service.EurekaService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/eureka")
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

    private boolean registerOk;


    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    @ApiOperation(value="向远程eureka 服务器注册", notes="")
    public ResultModel execRegister(
            @RequestParam(value = "remoteIp", required = true) String strRemoteIp,
            @RequestParam(value = "remotePort", required = true) String strRemotePort) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        ResultModel rm = eurekaService.doRegistert(strRemoteIp, strRemotePort, strAppId, strPort);
        log.info("EurekaTask execRegister: current time: " + sdf.format(d) + ", Register resutl: " + rm.toString());
        return rm;
    }


    @RequestMapping(value = "heartbeat", method = RequestMethod.PUT)
    @ApiOperation(value="向远程eureka 心跳", notes="")
    public ResultModel execHeartBeat(
            @RequestParam(value = "remoteIp", required = true) String strRemoteIp,
            @RequestParam(value = "remotePort", required = true) String strRemotePort) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        log.info("[doHeartBeat]...begin to execHeartBeat,current time: " + sdf.format(d));
        ResultModel rm = eurekaService.doHeartBeat(strRemoteIp, strRemotePort, strAppId, strPort);
        return rm;

    }


}
