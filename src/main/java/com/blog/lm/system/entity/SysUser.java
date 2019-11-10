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
 * @author xus
 * @since 2019-11-06
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 显示名称
     */
    private String userDisplayName;

    /**
     * 密码
     */
    private String userPass;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 头像
     */
    private String userAvatar;

    /**
     * 描述
     */
    private String userDesc;

    /**
     * 个人主页
     */
    private String userSite;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime loginLast;

    /**
     * 0-正常，1-禁用
     */
    private String status;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 1删除，0未删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户角色
     */
    @TableField(exist = false)
    private List<Integer> roles;


}
