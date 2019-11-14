package com.blog.lm.system.controller;


import com.blog.lm.system.entity.SysMenu;
import com.blog.lm.system.service.SysMenuService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
     * 获取未登录状态的菜单树
     * @return
     */
    @GetMapping("/api/menuTree")
    public JsonResult getMenuTree() {
        return new JsonResult(menuService.getMenuTree());
    }

    /**
     * 获取登录状态用户的菜单树
     * @return
     */
    @GetMapping("/menu/userMenuTree")
    @PreAuthorize("@pms.hasPermission('get_user_menu')")
    public JsonResult getUserMenuTree(){
        return new JsonResult(menuService.getUserMenuTree());
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
    @GetMapping("/menu/roleMenuTree/{roleId}")
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
    public JsonResult saveMenu(@RequestBody SysMenu sysMenu) {
        return new JsonResult(menuService.saveMenu(sysMenu));
    }

    /**
     * 修改菜单
     * @param sysMenu
     * @return
     */
    @PutMapping("/menu")
    @PreAuthorize("@pms.hasPermission('edit_menu')")
    public JsonResult editMenu(@RequestBody SysMenu sysMenu){
        return new JsonResult(menuService.editMenu(sysMenu));
    }


    @DeleteMapping("/menu/{id}")
    @PreAuthorize("@pms.hasPermission('delete_menu')")
    public JsonResult deleteMenu(@PathVariable Integer id){
        return new JsonResult(menuService.deleteMenu(id));
    }

}

