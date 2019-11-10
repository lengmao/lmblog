package com.blog.lm.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页
     * @param page
     * @param sysRole
     * @return
     */
    IPage rolePage(Page<SysRole> page, @Param("sysRole") SysRole sysRole);
    /**
     * 通过用户ID查询用户所有角色
     * @param userId
     * @return
     */
    List<SysRole> getRolesByUserId(@Param("userId") Integer userId);


}
