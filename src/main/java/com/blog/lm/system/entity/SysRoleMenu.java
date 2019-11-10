package com.blog.lm.system.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 角色权限表

 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@Data
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 菜单Id
     */
    private Integer menuId;


}
