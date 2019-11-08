package com.blog.lm.busi.service;

import com.blog.lm.busi.entity.SysMenu;
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
    List<MenuTree> getMenuTreeByRoleId(Integer roleId);

    /**
     * 获取菜单树
     * @return
     */
    List<MenuTree> getMenuTree();
}
