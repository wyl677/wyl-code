package com.wyl.docker.controller;

import cn.hutool.core.util.IdUtil;
import com.wyl.docker.entities.User;
import com.wyl.docker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @auther yanl.wang
 * @date 2022/6/26
 **/
@Api(description = "用户User接口")
@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("数据库新增 3 条记录")
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public void addUser(){
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUsername("wyl"+i);
            user.setPassword(IdUtil.simpleUUID().substring(0,6));
            user.setSex((byte) new Random().nextInt(2));
            userService.addUser(user);
        }
    }

    @ApiOperation("查询1条记录")
    @RequestMapping(value = "/user/find/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }

}
