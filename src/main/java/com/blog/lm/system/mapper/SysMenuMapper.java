package com.blog.lm.system.mapper;

import com.blog.lm.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单 Mapper 接口
 *
 * @author xus
 * @since 2019-11-06
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过角色ID获取菜单
     *
     * @param roleId
     * @return
     */
    List<SysMenu> getMenusByRoleId(@Param("roleId") Integer roleId);
}
