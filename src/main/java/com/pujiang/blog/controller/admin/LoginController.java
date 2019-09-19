package com.pujiang.blog.controller.admin;

import com.pujiang.blog.bean.User;
import com.pujiang.blog.service.UserService;
import com.pujiang.blog.util.MD5Util;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResBean login(User user, HttpSession session) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        user = userService.login(user);
        if (user!=null){
            session.setAttribute("loginInfo",user);
            return new ResBean(1);
        }
        return new ResBean(0);
    }

    @RequestMapping("/logout")
    public ResBean logout(HttpSession session){
        session.removeAttribute("loginInfo");
        return  new ResBean(1);
    }
}
