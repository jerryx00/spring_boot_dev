package com.neo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient(name= "demo")
public interface DemoRemote {

    @GetMapping("/demo/demo")
    public String demo(@RequestParam(value="name", required=false, defaultValue="Feign") String name);
}