package com.blog.lm.busi.controller;


import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.busi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块接口
 * @author xus
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService userService;

    @GetMapping("/list")
    public SysUser getUsers() {
        return userService.getById(1);
    }

}

