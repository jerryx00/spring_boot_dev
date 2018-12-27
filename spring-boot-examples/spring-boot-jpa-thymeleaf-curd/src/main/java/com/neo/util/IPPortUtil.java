package com.neo.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Set;


public class IPPortUtil {

    private static final Logger log = LoggerFactory.getLogger(IPPortUtil.class);

    /**
     * @return
     * @throws MalformedObjectNameException
     * 获取当前机器的端口号
     */
    public static String getLocalPort() throws MalformedObjectNameException {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String port = objectNames.iterator().next().getKeyProperty("port");
        return port;
    }

    /**
     * @return
     * 获取当前机器的IP
     */
    public static String getLocalIP() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }


        byte[] ipAddr = addr.getAddress();
        String ipAddrStr = "";
        for (int i = 0; i < ipAddr.length; i++) {
            if (i > 0) {
                ipAddrStr += ".";
            }
            ipAddrStr += ipAddr[i] & 0xFF;
        }
        return ipAddrStr;
    }

    public static String getHostName() {
        String hostName = "";
        try{
            InetAddress addr = InetAddress.getLocalHost();
            String ip=addr.getHostAddress().toString(); //获取本机ip
            hostName=addr.getHostName().toString(); //获取本机计算机名称
            log.info("本机IP："+ip+"\n本机名称:"+hostName);
        }catch(Exception e){
            e.printStackTrace();
        }
        return hostName;
    }

}
