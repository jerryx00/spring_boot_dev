package com.neo.web;

import com.neo.service.DemoRemote;
import com.neo.service.HelloRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    HelloRemote helloRemote;
    @Autowired
    DemoRemote demoRemote;

    @GetMapping("/hello")
    public String index(@RequestParam(value="name", required=false, defaultValue="Remote") String name) {
        log.info("run helloRemote......");
        return helloRemote.hello(name);
    }

    @GetMapping("/demo")
    public String demo(@RequestParam(value="name", required=false, defaultValue="Demo") String name) {
        log.info("run helloRemote......" + name);
        return demoRemote.demo(name);
    }
    @RequestMapping("/ho")
    public String hh(@RequestParam(value="name", required=false, defaultValue="Remote") String name) {
         return "Ho Ho Ho";
    }

}
