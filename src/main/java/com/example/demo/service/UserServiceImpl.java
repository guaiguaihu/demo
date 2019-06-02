package com.example.demo.service;

import com.example.demo.dao.IUserDAO;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserServiceImpl
 *
 * @author liujinliang
 * @date 2019/5/7
 **/
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource
    private IUserDAO userDao;

    @Override
    public void saveUser(User user) {
        userDao.insert(user);
    }
}
