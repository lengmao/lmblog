package com.blog.lm.busi.service;

import com.blog.lm.busi.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xus
 * @since 2019-11-06
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过用户名获取用户详细信息(登录使用)
     * @param username
     * @return
     */
    SysUser getUserByName(String username);
}
