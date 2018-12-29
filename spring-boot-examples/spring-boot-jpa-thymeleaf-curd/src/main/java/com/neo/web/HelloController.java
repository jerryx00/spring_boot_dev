package com.neo.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/h")
    @ApiOperation(value="返回Model", notes="")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello model";
    }
    @GetMapping("/hello")
    @ApiOperation(value="测试Hello", notes="默认返回Hello world")
    public String hello(@RequestParam(value = "name",required = false, defaultValue = "world") String name){
        return "Hello " + name;
    }
}
