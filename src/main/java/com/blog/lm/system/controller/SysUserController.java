package com.blog.lm.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.service.SysUserService;
import com.blog.lm.common.result.JsonResult;
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
public class SysUserController {

    @Autowired
    SysUserService userService;

    /**
     * 用户分页
     *
     * @param page
     * @param sysUser
     * @return
     */
    @GetMapping("/user/page")
    @PreAuthorize("@pms.hasPermission('user_page')")
    public JsonResult userPage(Page<SysUser> page, SysUser sysUser) {
        return new JsonResult(userService.userPage(page, sysUser));
    }

    /**
     * 通过ID查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @PreAuthorize("@pms.hasPermission('get_user')")
    public JsonResult getUserById(@PathVariable Integer id) {
        return new JsonResult(userService.getById(id));
    }

    /**
     * 用户注册
     *
     * @param sysUser
     * @param codeStr
     * @return
     */
    @PostMapping("/api/register")
    public JsonResult registerUser(@RequestBody SysUser sysUser, @RequestParam String codeStr) throws Exception {
        return new JsonResult(userService.registerUser(sysUser, codeStr));
    }

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping("/user")
    @PreAuthorize("@pms.hasPermission('add_user')")
    public JsonResult save(@RequestBody SysUser sysUser) {
        return new JsonResult(userService.saveUser(sysUser));
    }


    /**
     * 修改用户
     *
     * @param sysUser
     * @return
     */
    @PutMapping("/user")
    @PreAuthorize("@pms.hasPermission('edit_user')")
    public JsonResult edit(@RequestBody SysUser sysUser) {
        return new JsonResult(userService.editUser(sysUser));
    }

    /**
     * 删除用户
     *
     * @return
     */
    @DeleteMapping("/user/{id}")
    @PreAuthorize("@pms.hasPermission('delete_user')")
    public JsonResult delete(@PathVariable Integer id) {
        return new JsonResult(userService.removeUser(id));
    }

}

