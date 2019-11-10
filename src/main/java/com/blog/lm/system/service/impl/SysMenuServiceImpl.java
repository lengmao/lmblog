package com.blog.lm.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blog.lm.system.entity.SysMenu;
import com.blog.lm.system.entity.SysRole;
import com.blog.lm.system.mapper.SysMenuMapper;
import com.blog.lm.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.system.service.SysRoleService;
import com.blog.lm.system.service.SysUserService;
import com.blog.lm.common.dto.UserDto;
import com.blog.lm.util.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private static final String ANON_USER = "anonymousUser";
    private static final String ANON_ROLE = "ROLE_ANON";

    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysMenuService sysMenuService;

    /**
     * 通过角色ID获取菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> getMenusByRoleId(Integer roleId) {
        return baseMapper.getMenusByRoleId(roleId);
    }

    /**
     * 获取角色所有拥有的菜单书
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> getMenuTreeByRoleId(Integer roleId) {
        List<SysMenu> menus = this.getMenusByRoleId(roleId);
        return null;
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @Override
    public List<SysMenu> getMenuTree() {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //如果未登录，只有一个角色，用角色唯一标识查权限
        if (ANON_USER.equals(userName)) {
            SysRole role = sysRoleService.getOne(Wrappers.<SysRole>query().lambda().eq(SysRole::getRoleCode, ANON_ROLE));
            List<SysMenu> menus = this.getMenusByRoleId(role.getId());
            return MenuTreeUtil.treeNode(menus);
        }
        //如果已经登录，按用户所赋予的角色查出权限
        else {
            UserDto userDto = sysUserService.getUserByName(userName);
            Set<SysMenu> setMenu = new LinkedHashSet<>();
            userDto.getRoleList().stream().forEach(r -> {
                List<SysMenu> temps = sysMenuService.getMenusByRoleId(r);
                setMenu.addAll(temps);
            });
            List<SysMenu> menus = setMenu.stream().distinct().collect(Collectors.toList());
            return MenuTreeUtil.treeNode(menus);
        }
    }

    /**
     * 获取所有菜单树
     *
     * @return
     */
    @Override
    public List<SysMenu> getAllMenuTree() {
        return MenuTreeUtil.treeNode(this.list());
    }
}
