package com.blog.lm.busi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

/**
 * 文章信息表
 *
 * @author xus
 * @since 2019-11-12
 */
@Data
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章所属用户ID
     */
    private Integer userId;

    /**
     * 文章所属菜单（即分类）ID
     */
    private Integer menuId;

    /**
     * 文章所属标签ID
     */
    private Integer tagId;

    /**
     * 文章标题
     */
    private String postTitle;

    /**
     * 文章封面图片
     */
    private String coverImage;

    /**
     * 文章副标题或摘要
     */
    private String postAbstract;

    /**
     * 文章内容 html格式
     */
    private String postContent;

    /**
     * 文章内容 md格式
     */
    private String postContentMd;

    /**
     * 文章状态 0-已发布 1-审核中 2-审核未通过
     */
    private String postStatus;

    /**
     * 文章访问量
     */
    private Integer postView=0;

    /**
     * 文章点赞量
     */
    private Integer postLike=0;

    /**
     * 文章来源
     */
    private String postSource;

    /**
     * 是否允许评论 0-是 1-否
     */
    private String allowComment;

    /**
     * 逻辑删除标记 0-正常 1-删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 评论数量
     */
    @TableField(exist = false)
    private Integer postComment;

}
