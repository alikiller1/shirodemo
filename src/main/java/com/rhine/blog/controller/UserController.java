package com.rhine.blog.controller;

import com.rhine.blog.po.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

@Controller
public class UserController {

    @RequestMapping("/user/index")
    public String add(HttpServletRequest request){
        UserBean bean = (UserBean) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("userName", bean.getName());
        return "/user/index";
    }
    
    @RequiresRoles(value= {"vip"})
    @RequestMapping("/vip/index")
    public String update(){
        return "/vip/index";
    }
}
