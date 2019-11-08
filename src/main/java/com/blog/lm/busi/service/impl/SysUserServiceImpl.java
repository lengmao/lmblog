package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.SysMenu;
import com.blog.lm.busi.entity.SysRole;
import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.busi.entity.SysUserRole;
import com.blog.lm.busi.mapper.SysUserMapper;
import com.blog.lm.busi.service.SysMenuService;
import com.blog.lm.busi.service.SysRoleService;
import com.blog.lm.busi.service.SysUserRoleService;
import com.blog.lm.busi.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.common.constant.CommonConstant;
import com.blog.lm.common.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xus
 * @since 2019-11-06
 */
@Service

public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private BCryptPasswordEncoder ENCODER;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysMenuService menuService;
    @Autowired
    private SysUserRoleService userRoleService;

    /**
     * 用户分页
     * @param page
     * @param sysUser
     * @return
     */
    @Override
    public IPage<SysUser> userPage(Page<SysUser> page, SysUser sysUser) {
       return baseMapper.userPage(page,sysUser);
    }

    /**
     * 通过用户名查询用户详细信息
     *
     * @param username
     * @return
     */
    @Override
    public UserDto getUserByName(String username) {
        UserDto userDto = new UserDto();
        SysUser sysUser = this.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUserName, username));
        userDto.setSysUser(sysUser);

        //查询用户角色
        List<Integer> roleIds = roleService.getRolesByUserId(sysUser.getId())
                .stream()
                .map(SysRole::getId)
                .collect(Collectors.toList());
        userDto.setRoleList(roleIds);

        //设置权限信息
        Set<String> permissions = new HashSet<>();
        roleIds.stream().forEach(r -> {
            List<SysMenu> menus = menuService.getMenusByRoleId(r);
            List<String> tempList = menus
                    .stream()
                    .filter(menu -> StringUtils.isNotEmpty(menu.getPermission()))
                    .map(SysMenu::getPermission)
                    .collect(Collectors.toList());
            permissions.addAll(tempList);
        });
        List<String> permissionList = permissions.stream().distinct().collect(Collectors.toList());
        userDto.setPermissions(permissionList);
        return userDto;
    }

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public Boolean saveUser(SysUser sysUser) {
        sysUser.setDelFlag(CommonConstant.STATUS_NORMAL);
        sysUser.setCreateTime(LocalDateTime.now());
        sysUser.setStatus(CommonConstant.STATUS_NORMAL);
        sysUser.setUserPass(ENCODER.encode(sysUser.getUserPass()));
        baseMapper.insert(sysUser);
        List<Integer> roles = sysUser.getRoles();
        roles.stream().forEach(r -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getId());
            userRole.setRoleId(r);
            userRoleService.save(userRole);
        });
        return Boolean.TRUE;
    }

    /**
     * 修改用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public Boolean editUser(SysUser sysUser) {
        //更新用户
        this.updateById(sysUser);
        //删除用户之前的角色
        userRoleService.remove(Wrappers.<SysUserRole>update().lambda().eq(SysUserRole::getUserId, sysUser.getId()));
        //添加用户新角色
        sysUser.getRoles().stream().forEach(r -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getId());
            userRole.setRoleId(r);
            userRoleService.save(userRole);
        });
        return Boolean.TRUE;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public Boolean removeUser(Integer id) {
        //删除用户角色关系
        userRoleService.remove(Wrappers.<SysUserRole>update().lambda().eq(SysUserRole::getUserId, id));
        //删除用户
        this.removeById(id);
        return Boolean.TRUE;
    }
}
