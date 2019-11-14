package com.blog.lm.system.service;

import com.blog.lm.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 通过角色ID获取菜单
     * @param roleId
     * @return
     */
    List<SysMenu> getMenusByRoleId(Integer roleId);

    /**
     * 获取角色所拥有的菜单树
     * @param roleId
     * @return
     */
    List<SysMenu> getMenuTreeByRoleId(Integer roleId);

    /**
     * 获取菜单树
     * @return
     */
    List<SysMenu> getMenuTree();

    List<SysMenu> getUserMenuTree();

    /**
     * 获取所有菜单树
     * @return
     */
    List<SysMenu> getAllMenuTree();

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    Boolean saveMenu(SysMenu sysMenu);

    /**
     * 修改菜单
     * @param sysMenu
     * @return
     */
    Boolean editMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    Boolean deleteMenu(Integer id);


}
