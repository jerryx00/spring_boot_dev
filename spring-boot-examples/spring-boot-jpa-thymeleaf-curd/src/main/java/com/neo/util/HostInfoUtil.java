package com.neo.util;

import java.net.InetAddress;
import java.util.Properties;

public class HostInfoUtil {
    public static String getIp(){
        String ip = "";
        try{
            InetAddress addr = InetAddress.getLocalHost();
            ip=addr.getHostAddress().toString(); //获取本机ip
        }catch(Exception e){
            e.printStackTrace();
        }
        return ip;
    }

    public static String getHostName(){
        String hostName = "";
        try{
            InetAddress addr = InetAddress.getLocalHost();
            hostName=addr.getHostName().toString(); //获取本机计算机名称
        }catch(Exception e){
            e.printStackTrace();
        }
        return hostName;
    }

}
