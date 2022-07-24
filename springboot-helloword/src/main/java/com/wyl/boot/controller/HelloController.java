package com.wyl.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther yanl.wang
 * @date 2022/6/1
 **/
//@ResponseBody //给浏览器返回数据
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
      return "Hello Springboot2!";
    }
}
