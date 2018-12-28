package com.neo.service;
;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient(name= "SPRING-CLOUD-STUDY-DEMO")
public interface HelloRemote {

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "name",required = false, defaultValue = "feign") String name);


}