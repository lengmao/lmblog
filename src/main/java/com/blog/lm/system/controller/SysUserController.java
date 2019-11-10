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
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService userService;

    /**
     * 用户分页
     * @param page
     * @param sysUser
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@pms.hasPermission('user_page')")
    public JsonResult userPage(Page<SysUser> page, SysUser sysUser){
        return new JsonResult(userService.userPage(page,sysUser));
    }

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('get_user')")
    public JsonResult getUserById(@PathVariable Integer id) {
        return new JsonResult(userService.getById(id));
    }


    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping
    @PreAuthorize("@pms.hasPermission('add_user')")
    public JsonResult save(@RequestBody SysUser sysUser) {
        return new JsonResult(userService.saveUser(sysUser));
    }


    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @PutMapping
    @PreAuthorize("@pms.hasPermission('edit_user')")
    public JsonResult edit(@RequestBody SysUser sysUser) {
        return new JsonResult(userService.editUser(sysUser));
    }

    /**
     * 删除用户
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('delete_user')")
    public JsonResult delete(@PathVariable Integer id){
        return new JsonResult(userService.removeUser(id));
    }

}

