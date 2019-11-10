package com.blog.lm.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页
     *
     * @param page
     * @param sysRole
     * @return
     */
    IPage rolePage(Page<SysRole> page, SysRole sysRole);

    /**
     * 通过用户ID查询用户所有角色
     *
     * @param userId
     * @return
     */
    List<SysRole> getRolesByUserId(Integer userId);

    /**
     * 修改角色信息，跟新角色菜单权限
     * @param sysRole
     * @param menuIds
     * @return
     */
    Boolean editRole(SysRole sysRole, Integer[] menuIds);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Boolean removeRole(Integer id);
}
