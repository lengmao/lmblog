package com.blog.lm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
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


    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value ="菜单ID" )
    private Integer id;

    @ApiModelProperty(value ="父及Id" )
    private Integer menuPid;

    @ApiModelProperty(value ="菜单名称" )
    private String menuName;

    @ApiModelProperty(value ="菜单权限标识" )
    private String permission;

    @ApiModelProperty(value ="菜单路径" )
    private String menuUrl;

    @ApiModelProperty(value ="排序编号" )
    private Integer menuSort;

    @ApiModelProperty(value ="图标，可选，部分主题可显示" )
    private String menuIcon;

    @ApiModelProperty(value ="删除状态：1删除，0未删除" )
    @TableLogic
    private String delFlag="0";

    @ApiModelProperty(value ="创建人用户名" )
    private String createBy;

    @ApiModelProperty(value ="创建时间" )
    private LocalDateTime createTime;

    @ApiModelProperty(value ="更新人" )
    private String updateBy;

    @ApiModelProperty(value ="更新时间" )
    private LocalDateTime updateTime;

    @TableField(exist = false)
    @ApiModelProperty(value ="子菜单" )
    private List<SysMenu> child;


}
