package com.example.demo.controller;

import com.example.demo.domain.UserDomain;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author liujinliang
 * @date 2019/5/7
 **/
@RestController
@EnableAutoConfiguration
@RequestMapping("api/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDomain user(String name, Long id){
//        User user = new User();
//        user.setUsername(name);
//        user.setPassword(name);
//        userService.saveUser(user);
        return  null;
    }


    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public UserDomain testApi(String name, Long id){
//        User user = new User();
//        user.setUsername(name);
//        user.setPassword(name);
//        userService.saveUser(user);
        return  null;
    }

}
