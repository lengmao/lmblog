package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.busi.mapper.SysUserMapper;
import com.blog.lm.busi.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.common.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author xus
 * @since 2019-11-06
 */
@Service

public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private BCryptPasswordEncoder ENCODER;

    /**
     * 通过用户名查询用户详细信息
     *
     * @param username
     * @return
     */
    @Override
    public SysUser getUserByName(String username) {
        SysUser user = this.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUserName, username));

        //TODO 查询用户角色个权限标识

        return user;
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
        //TODO 设置用户角色
        return Boolean.TRUE;
    }
}
