package com.neo.schedule;

import com.neo.entity.ResultModel;
import com.neo.service.EurekaService;
import com.neo.web.EurekaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EurekaTask {

    private static final Logger log = LoggerFactory.getLogger(EurekaTask.class);

    @Value("${server.port}")
    private String strPort;

    @Value("${spring.application.name}")
    private String strAppId;

    @Value("${jzt.application.remote.ip}")
    private String strRemoteIp;

    @Value("${jzt.application.remote.port}")
    private String strRemotePort;

    @Value("${jzt.patrol.register.maxtimes}")
    private int maxegisterTimes;

    @Value("${scheduled.enable}")
    private String scheduledEnable;

    @Value("${eureka.register.enabled}")
    private boolean registerEnabled;



    @Autowired
    EurekaService eurekaService;

    private boolean registerOk = false;
    private int registerTimes = 1;
    private int heatbeatTimes = 1;

    // 间隔毫秒,执行任务
    @Scheduled(initialDelay = 20000, fixedDelayString = "${jzt.patrol.register.timeinms}")
    public void execRegister() {
        if(!registerEnabled || "".equals(strRemoteIp)){
            return;
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        log.info("[doHeartBeat]...begin to execRegister,current time: " + sdf.format(d) + ", try times: " + registerTimes);
        if (!registerOk && (registerTimes < maxegisterTimes)) {
            ResultModel rm = eurekaService.doRegistert(strRemoteIp, strRemotePort, strAppId, strPort);
            log.info("EurekaTask execRegister: current time: " + sdf.format(d) + ", try times: " + registerTimes + ", registerStatus: " + rm.getHttpStatus());
            registerTimes ++;
        }
    }

    // 间隔2分钟,执行任务
//    @Scheduled(cron="0 0/2 * * * ?")
//    @Scheduled(cron = "${jzt.patrol.heartbeat.timeinms}")
    @Scheduled(cron = "${jzt.patrol.heartbeat.cron}")
    public void execHeartBeat() {
        if(!registerEnabled || "".equals(strRemoteIp)){
            return;
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
        ResultModel rm = eurekaService.doHeartBeat(strRemoteIp, strRemotePort, strAppId, strPort);
        log.info("[doHeartBeat]...begin to execHeartBeat,current time: " + sdf.format(d) + ",result is " + rm.getHttpStatus() );
        heatbeatTimes ++;
    }

}
