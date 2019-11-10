package com.blog.lm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author xus
 * @since 2019-11-06
 */
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String role;

    /**
     * 用户编码
     */
    private String roleCode;

    /**
     * 描述
     */
    private String description;

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
