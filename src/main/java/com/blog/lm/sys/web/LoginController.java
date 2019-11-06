package com.blog.lm.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xus
 * @Date 2019/11/6 17:44
 * @Description TODO
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
