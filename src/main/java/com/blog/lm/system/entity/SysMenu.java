package com.blog.lm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父及Id
     */
    private Integer menuPid;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 排序编号
     */
    private Integer menuSort;

    /**
     * 图标，可选，部分主题可显示
     */
    private String menuIcon;

    /**
     * 删除状态：1删除，0未删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 创建人用户名
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private List<SysMenu> child;


}
