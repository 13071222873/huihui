package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        boolean flag = userService.login(username, password);
        if(flag){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("flag",flag);
            map.put("msg","恭喜您登录成功");
            request.getSession().setAttribute("user",username);
            ObjectMapper om = new ObjectMapper();
            String s = om.writeValueAsString(map);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(s);
            return;
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("flag",flag);
        map.put("msg","登录失败，账号名密码错误");
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(map);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
