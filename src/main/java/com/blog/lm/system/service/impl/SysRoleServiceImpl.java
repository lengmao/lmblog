package com.blog.lm.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysRole;
import com.blog.lm.system.entity.SysRoleMenu;
import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.mapper.SysRoleMapper;
import com.blog.lm.system.service.SysRoleMenuService;
import com.blog.lm.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    SysRoleMenuService roleMenuService;
    @Autowired
    SysUserService userService;

    /**
     * 分页
     *
     * @param page
     * @param sysRole
     * @return
     */
    @Override
    public IPage rolePage(Page<SysRole> page, SysRole sysRole) {
        return baseMapper.rolePage(page, sysRole);
    }

    /**
     * 通过用户ID查询用户所有角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> getRolesByUserId(Integer userId) {
        return baseMapper.getRolesByUserId(userId);
    }


    /**
     * 修改角色信息，更新角色菜单权限
     *
     * @param sysRole
     * @param menuIds
     * @return
     */
    @Override
    public Boolean editRole(SysRole sysRole, Integer[] menuIds) {
        this.updateById(sysRole);
        roleMenuService.remove(Wrappers.<SysRoleMenu>update().lambda().eq(SysRoleMenu::getRoleId, sysRole.getId()));
        Arrays.stream(menuIds).forEach(id -> {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(sysRole.getId());
            roleMenu.setMenuId(id);
            roleMenuService.save(roleMenu);
        });
        return Boolean.TRUE;
    }

    @Override
    public Boolean removeRole(Integer id) {
        List<SysUser> users = userService.getUserByRoleId(id);
        if (users.size() == 0) {
            return this.removeById(id);
        }
        return Boolean.FALSE;
    }
}
