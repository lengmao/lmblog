package com.blog.lm.common.dto;

import com.blog.lm.system.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @Author xus
 * @Date 2019/11/6 14:29
 * @Description TODO
 **/
@Data
public class UserDto {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;

    /**
     * 角色列表
     */
    private List<Integer> roleList;

    /**
     * 权限标识列表
     */
    private List<String> permissions;
}
