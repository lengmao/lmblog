package com.blog.lm.busi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 标签信息表
 * @author xus
 * @since 2019-11-12
 */
@Data
public class Tag implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value ="主键" )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value ="标签所属用户ID" )
    private Integer userId;

    @ApiModelProperty(value ="标签名称" )
    private String tagName;

    @ApiModelProperty(value ="创建时间" )
    private LocalDateTime createTime;

    @TableLogic
    @ApiModelProperty(value ="逻辑删除标记 0-正常 1-删除" )
    private String delFlag;


}
