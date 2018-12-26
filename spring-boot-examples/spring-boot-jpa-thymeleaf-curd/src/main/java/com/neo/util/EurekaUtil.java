package com.neo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neo.entity.eureka.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EurekaUtil {
    private static final Logger log = LoggerFactory.getLogger(EurekaUtil.class);

    public static String getPara(String strRemoteIp, String strRemotePort,String strAppId, String strPort) {
        String localIp = getIp();
        String hostname = getHostname();
        String time = getCurrentTime();
        String instanceId = localIp + ":" + strAppId + ":" + strPort;
        String strHomePageUrl = getProtocal() + "://" + getIp() + ":" + strPort + "/";
        String registeUrl = getProtocal() + "://" + strRemoteIp + ":" +  strRemotePort + "/eureka/" + strAppId;


        InstanceDetail insd = new InstanceDetail();
        insd.setApp(strAppId);
        insd.setInstanceId(instanceId);
        insd.setHostName(hostname);
        insd.setIpAddr(localIp);
        insd.setHomePageUrl(strHomePageUrl);
        insd.setSecureHealthCheckUrl(strHomePageUrl + "actuator/info");
        insd.setHealthCheckUrl(strHomePageUrl + "actuator/health");
        insd.setVipAddress(strAppId);
        insd.setSecureVipAddress(strAppId);

        DataCenterInfo dataCenterInfo = new DataCenterInfo();
        insd.setDataCenterInfo(dataCenterInfo);

        SecurePort securePort = new SecurePort();
        insd.setSecurePort(securePort);

        Port port = new Port();
        port.setY_y(strPort);

        insd.setPort(port);

        Metadata metadata = new Metadata();
        insd.setMetadata(metadata);

        insd.setLastDirtyTimestamp(time);
        insd.setLastUpdatedTimestamp(time);

        Instance instance = new Instance();
        instance.setInstance(insd);

        String s = "";
        try {
            s = JacksonUtils.beanToJson(instance);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //替换文本
        String x = s.replaceAll("x_x", "@");
        String v = x.replaceAll("y_y", "\\$");
        return v;
    }

    public static String getRegistertUrl(String remoteIp, String remotePort, String strAppId) {

        String registertUrl = getProtocal() + "://" + remoteIp + ":" +  remotePort + "/eureka/apps/" + strAppId;

        log.info("[Instance]..." + registertUrl);
        return registertUrl;
    }

    public static String getHeartUrl(String remoteIp, String remotePort, String strAppId, String instanceId) {

        String heartUrl = getProtocal() + "://" + remoteIp + ":" +  remotePort + "/eureka/apps/" + strAppId + "/" + instanceId;

        log.info("[Instance]..." + heartUrl);
        return heartUrl;
    }

    public static String getHeartUrlPrefix(String remoteIp, String remotePort) {

        String heartUrlPrefix = getProtocal() + "://" + remoteIp + ":" +  remotePort + "/eureka/apps/";

        log.info("[Instance]..." + heartUrlPrefix);
        return heartUrlPrefix;
    }


    public static String getInstanceId(String strAppId, String strPort) {
        String localIp = getIp();
        String instanceId = localIp + ":" + strAppId + ":" + strPort;
        return instanceId;
    }
    private static String getIp() {
        return "127.0.0.1";
    }
    private static String getHostname() {
        return "localhost";
    }

    private static String getCurrentTime() {
        Long time = System.currentTimeMillis();
        return String.valueOf(time);
    }
    private static String getProtocal() {
        return "http";
    }
}
