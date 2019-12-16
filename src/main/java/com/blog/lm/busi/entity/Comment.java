package com.blog.lm.busi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 评论信息表
 * @author xus
 * @since 2019-11-12
 */
@Data
@TableName("busi_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value ="主键" )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value ="评论所属文章id" )
    private Integer postId;

    @ApiModelProperty(value ="发布评论用户id" )
    private Integer fromUid;

    @ApiModelProperty(value ="评论内容" )
    private String commentContent;

    @ApiModelProperty(value ="评论状态 0-正常 1-待审核" )
    private String commentStatus;

    @ApiModelProperty(value ="评论类型 0-匿名 1-登录者" )
    private String commentType;

    @ApiModelProperty(value ="创建时间" )
    private LocalDateTime createTime;

    @ApiModelProperty(value ="逻辑删除标记 0-正常 1-删除" )
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value ="备注信息" )
    private String remarks;

}
