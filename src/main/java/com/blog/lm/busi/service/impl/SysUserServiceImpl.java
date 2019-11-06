package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.busi.mapper.SysUserMapper;
import com.blog.lm.busi.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xus
 * @since 2019-11-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser getUserByName(String username) {
        SysUser user = this.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUserName, username));

        //TODO 查询用户角色个权限标识

        return user;
    }
}
