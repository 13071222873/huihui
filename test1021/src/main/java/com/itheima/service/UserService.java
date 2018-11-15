package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;

public interface UserService {
    UserDao userDao = new UserDaoImpl();

    public boolean register(String username,String password);

    public boolean login(String username,String password);
}
