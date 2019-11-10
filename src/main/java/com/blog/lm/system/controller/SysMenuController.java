package com.blog.lm.system.controller;


import com.blog.lm.system.service.SysMenuService;
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
     * 获取未登录或已登录用户的菜单树
     * @return
     */
    @GetMapping("/api/menuTree")
    public JsonResult getMenuTree() {
        return new JsonResult(menuService.getMenuTree());
    }

    /**
     * 此接口旨在管理员修改角色权限时获取所有菜单，因此权限标识为edit_role
     * @return
     */
    @GetMapping("/menu/allMenuTree")
    @PreAuthorize("@pms.hasPermission('edit_role')")
    public JsonResult getAllMenuTree(){
        return new JsonResult(menuService.getAllMenuTree());
    }

    /**
     * 通过角色ID获取角色资源
     * @param roleId
     * @return
     */
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

