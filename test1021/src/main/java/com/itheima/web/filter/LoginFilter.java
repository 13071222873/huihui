package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//默认拦截路径是所有  拦截方式是浏览器请求和转发
@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //一般都会将req对象强转为HttpServletRequest类型
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取访问的路径
        String uri = request.getRequestURI();
        //如果是与登录相关的资源 则直接放行
        if(uri.contains("/login.html")
                || uri.contains("/css/")
                || uri.contains("/images/")
                || uri.contains("/js/")
                || uri.contains("loginServlet")
                || uri.contains("/register.html")
                || uri.contains("/registerServlet")){
            chain.doFilter(request,resp);
            return;
        }
        //如果不是与登录相关的资源  并且没有登录的话 需要转发到登录页面 并给出提示
                                    //如果已经登录  则直接放行
        Object name = request.getSession().getAttribute("user");
        if(name == null){
            //则表示没有登录
            //request.getRequestDispatcher("/login.html").forward(request,resp);
            response.sendRedirect(request.getContextPath()+"/login.html");
            return;
        }
        //放行
        chain.doFilter(req, resp);
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
