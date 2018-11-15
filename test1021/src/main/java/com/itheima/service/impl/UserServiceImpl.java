package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean register(String username, String password) {
        User user = userDao.findUserByUsername(username);
        if(user != null){
            return false;
        }
        userDao.register(username,password);
        return true;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userDao.login(username, password);
        if (user == null){
            return false;
        }
        return true;
    }
}
