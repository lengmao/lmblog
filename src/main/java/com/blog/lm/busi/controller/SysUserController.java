package com.blog.lm.busi.controller;


import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.busi.service.SysUserService;
import com.blog.lm.common.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户模块接口
 *
 * @author xus
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService userService;

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@pms.hasPermission('user_list')")
    public SysUser getUsers() {
        return userService.getById(1);
    }

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping
    public JsonResult save(@RequestBody SysUser sysUser) {
        return new JsonResult(userService.saveUser(sysUser));
    }

}

