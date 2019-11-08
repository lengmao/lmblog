package com.blog.lm.busi.controller;


import com.blog.lm.busi.service.SysMenuService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单 接口
 * @author xus
 * @since 2019-11-06
 */
@RestController
public class SysMenuController {

    @Autowired
    SysMenuService menuService;

    /**
     * 获取菜单树
     * @return
     */
    @GetMapping("/api/menuTree")
    public JsonResult getMenuTree() {
        return new JsonResult(menuService.getMenuTree());
    }

    @GetMapping("/menus/roleMenuTree/{roleId}")
    @PreAuthorize("@pms.hasPermission('edit_role')")
    public JsonResult getMenuTreeByRoleId(@PathVariable Integer roleId){
        return new JsonResult(menuService.getMenuTreeByRoleId(roleId));
    }
    /**
     * 添加菜单
     * @return
     */
    @PostMapping("/menu")
    @PreAuthorize("@pms.hasPermission('add_menu')")
    public JsonResult saveMenu() {
        return new JsonResult(Boolean.TRUE);
    }

}

