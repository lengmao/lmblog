package com.blog.lm.busi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
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

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评论所属文章id
     */
    private Integer postId;

    /**
     * 发布评论用户id
     */
    private Integer fromUid;

    /**
     * 评论内容
     */
    private String commentContent;


    /**
     * 评论状态 0-正常 1-待审核
     */
    private String commentStatus;

    /**
     * 评论类型 0-匿名 1-登录者
     */
    private String commentType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 逻辑删除标记 0-正常 1-删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注信息
     */
    private String remarks;

}
