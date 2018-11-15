package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.servlet.ServletRequest;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByUsername(String username) {
        String sql = " select * from user where username = ?";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void register(String username, String password) {
        String sql = "insert into user(username,password) values (?,?)";
        template.update(sql,username,password);
    }

    @Override
    public User login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return (user);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
