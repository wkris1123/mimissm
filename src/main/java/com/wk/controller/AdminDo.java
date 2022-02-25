package com.wk.controller;

import com.wk.entity.Admin;
import com.wk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @className: com.wk.controller.AdminDo
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-22 13:05
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminDo {
    //!!!!!!在所有的界面层，一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    @RequestMapping("/login.do")
    public String login(String name, String pwd, HttpServletRequest request){

        Admin admin=adminService.login(name,pwd);

        if(admin!=null){
            request.setAttribute("admin",admin);
            return "main";
        }else{
            request.setAttribute("errmsg","用户或密码错误！！");
            return "login";
        }
    }

}
