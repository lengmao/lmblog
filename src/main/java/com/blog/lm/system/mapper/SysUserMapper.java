package com.blog.lm.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author xus
 * @since 2019-11-06
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 用户分页
     *
     * @param page
     * @param sysUser
     * @return
     */
    IPage<SysUser> userPage(Page<SysUser> page, @Param("user") SysUser sysUser);

    /**
     * 通过角色ID查询用户
     * @param roleId
     * @return
     */
    List<SysUser> getUserByRoleId(@Param("roleId") Integer roleId);
}
