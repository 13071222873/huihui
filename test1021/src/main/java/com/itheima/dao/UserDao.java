package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.util.JDBCUtils;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.jdbc.core.JdbcTemplate;

public interface UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User findUserByUsername(String username);

    public void register(String username,String password);

    public User login(String username,String password);
}
