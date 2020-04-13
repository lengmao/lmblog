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
 * @author xus
 * @since 2019-11-06
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value ="主键" )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value ="用户名" )
    private String userName;

    @ApiModelProperty(value ="显示名称" )
    private String userDisplayName;

    @ApiModelProperty(value ="密码" )
    private String userPass;

    @ApiModelProperty(value ="邮箱" )
    private String userEmail;

    @ApiModelProperty(value ="头像" )
    private String userAvatar;

    @ApiModelProperty(value ="描述" )
    private String userDesc;

    @ApiModelProperty(value ="个人主页" )
    private String userSite;

    @ApiModelProperty(value ="最后一次登录时间" )
    private LocalDateTime loginLast;

    @ApiModelProperty(value ="0-正常，1-禁用" )
    private String status;

    @ApiModelProperty(value ="注册时间" )
    private LocalDateTime createTime;

    @ApiModelProperty(value ="1删除，0未删除" )
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value ="创建人" )
    private String createBy;

    @ApiModelProperty(value ="修改人" )
    private String updateBy;

    @ApiModelProperty(value ="修改时间" )
    private LocalDateTime updateTime;

    @ApiModelProperty(value ="用户角色集合" )
    @TableField(exist = false)
    private List<Integer> roles;


}
