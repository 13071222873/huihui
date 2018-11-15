package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帐户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request){
        List<Account> list = accountService.findAll();
        request.setAttribute("list",list);
        // 调用service的方法
        return "list";
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account,HttpServletResponse response,HttpServletRequest request) throws IOException {
        accountService.saveAccount(account);
       response.sendRedirect(request.getContextPath()+"/account/findAll");
    }



}
