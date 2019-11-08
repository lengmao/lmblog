package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.common.dto.UserDto;

/**
 * @author xus
 * @since 2019-11-06
 */
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> userPage(Page<SysUser> page, SysUser sysUser);
    /**
     * 通过用户名获取用户详细信息(登录使用)
     * @param username
     * @return
     */
    UserDto getUserByName(String username);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    Boolean saveUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    Boolean editUser(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean removeUser(Integer id);

}
