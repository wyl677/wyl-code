package com.wyl.boot.controller;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yanl.wang
 * @date 2023/2/21
 **/
//@ResponseBody 返回的数据写给浏览器
//@Controller
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        log.info("11111111111111"+ name);
        return "Hello,SpringBoot2!" + name;
    }

}
