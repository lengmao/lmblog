package com.blog.lm.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.common.dto.UserDto;

import java.util.List;

/**
 * @author xus
 * @since 2019-11-06
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 获取当前登陆用户
     * @return
     */
    SysUser getCurrentUser();

    /**
     * 分页
     *
     * @param page
     * @param sysUser
     * @return
     */
    IPage<SysUser> userPage(Page<SysUser> page, SysUser sysUser);

    /**
     * 通过用户名获取用户详细信息(登录使用)
     *
     * @param username
     * @return
     */
    UserDto getUserByName(String username);

    /**
     * 通过角色id查询用户
     *
     * @param roleId
     * @return
     */
    List<SysUser> getUserByRoleId(Integer roleId);

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    Boolean saveUser(SysUser sysUser);

    /**
     * 修改用户
     *
     * @param sysUser
     * @return
     */
    Boolean editUser(SysUser sysUser);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    Boolean removeUser(Integer id);

}
