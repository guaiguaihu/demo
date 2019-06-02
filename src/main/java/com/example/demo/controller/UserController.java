package com.example.demo.controller;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.dao.IUserDAO;
import com.example.demo.domain.UserDomain;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController extends BaseController {
    @Autowired
    private IUserDAO userDAO;

    @RequestMapping(value = "/table/list")
    public ResponseResult test2(String title){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        Item item = new Item();
        item.setAuthor("liu");
        item.setDisplay_time("2019-05-05");
        item.setId("id_001");
        item.setStatus("draft");
        item.setTitle("title_test");
        List<Item> itemsList = new ArrayList();
        itemsList.add(item);
        Items items = new Items();
        items.setTotal(itemsList.size());
        items.setItems(itemsList);
        responseResult.setData(items);
        responseResult.setData(items);
        return responseResult;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody UserDomain user, HttpSession session){
        if(user == null || user.getUsername() == null){
            return new ResponseResult();
        }
        User userDB = userDAO.getByUserName(user.getUsername());
        if(userDB == null){
            return new ResponseResult();
        }
        if(!userDB.getPassword().equals(user.getPassword())){
            return new ResponseResult();
        }
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        Token token = new Token();
        responseResult.setData(token);
        token.setToken(userDB.getUserName());
        session.setAttribute(WebSecurityConfig.SESSION_KEY, user);
        return responseResult;
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public ResponseResult logout(HttpSession session){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return responseResult;
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public ResponseResult getUserInfo(String token){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(STATUS_SUCCESS);
        User userDB = userDAO.getByUserName(token);
        UserInfo userInfo = new UserInfo();
        responseResult.setData(userInfo);
        userInfo.setName(userDB.getUserName());
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setRoles(new String[]{"admin"});
        userInfo.setIntroduction("I am a super administrator");
        return responseResult;
    }
}
