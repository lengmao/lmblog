package com.blog.lm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
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


    @ApiModelProperty(value ="主键" )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value ="角色名称" )
    private String role;

    @ApiModelProperty(value ="用户编码" )
    private String roleCode;

    @ApiModelProperty(value ="描述" )
    private String description;

    @TableLogic
    @ApiModelProperty(value ="1删除，0未删除" )
    private String delFlag;

    @ApiModelProperty(value ="创建人" )
    private String createBy;

    @ApiModelProperty(value ="创建时间" )
    private LocalDateTime createTime;

    @ApiModelProperty(value ="修改人" )
    private String updateBy;

    @ApiModelProperty(value ="修改时间" )
    private LocalDateTime updateTime;


}
