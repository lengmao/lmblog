package com.blog.lm.busi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
