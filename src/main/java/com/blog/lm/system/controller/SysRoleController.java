package com.blog.lm.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysRole;
import com.blog.lm.system.service.SysRoleService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    SysRoleService roleService;

    /**
     * 分页
     *
     * @param page
     * @param sysRole
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@pms.hasPermission('role_page')")
    public JsonResult rolePage(Page<SysRole> page, SysRole sysRole) {
        return new JsonResult(roleService.rolePage(page, sysRole));
    }

    /**
     * 通过ID获取角色
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @PreAuthorize("@pms.hasPermission('get_role')")
    public JsonResult getRoleById(@PathVariable Integer id) {
        return new JsonResult(roleService.getById(id));
    }

    /**
     * 添加角色
     *
     * @return
     */
    @PostMapping
    @PreAuthorize("@pms.hasPermission('add_role')")
    public JsonResult saveRole(@RequestBody SysRole sysRole) {
        if (null != sysRole.getRole()) {
            return new JsonResult(roleService.save(sysRole));
        }
        return new JsonResult("角色名称为空！");
    }

    /**
     * 修改角色信息，更新角色菜单权限
     *
     * @param sysRole
     * @param menuIds
     * @return
     */
    @PutMapping
    @PreAuthorize("@pms.hasPermission('edit_role')")
    public JsonResult editRole(@RequestBody SysRole sysRole, @RequestParam("menuIds") Integer[] menuIds) {
        if (null == sysRole.getId() && null == sysRole.getRole()) {
            return new JsonResult("角色id或名称为空！");
        }
        return new JsonResult(roleService.editRole(sysRole, menuIds));
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('delete_role')")
    public JsonResult delete(@PathVariable Integer id) {
        if (roleService.removeRole(id)) {
            new JsonResult(Boolean.TRUE);
        }
        return new JsonResult(new Exception("此角色绑定用户,不允许删除！"));
    }

}

