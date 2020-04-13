package com.blog.lm.busi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value ="主键" )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value ="文章所属用户ID" )
    private Integer userId;

    @ApiModelProperty(value ="文章所属菜单（即分类）ID" )
    private Integer menuId;

    @ApiModelProperty(value ="文章所属标签ID" )
    private Integer tagId;

    @ApiModelProperty(value ="文章标题" )
    private String postTitle;

    @ApiModelProperty(value ="文章封面图片" )
    private String coverImage;

    @ApiModelProperty(value ="文章副标题或摘要" )
    private String postAbstract;

    @ApiModelProperty(value ="文章内容 html格式" )
    private String postContent;

    @ApiModelProperty(value ="文章内容 md格式" )
    private String postContentMd;

    @ApiModelProperty(value ="文章状态 0-已发布 1-审核中 2-审核未通过" )
    private String postStatus;

    @ApiModelProperty(value ="文章访问量" )
    private Integer postView=0;

    @ApiModelProperty(value ="文章点赞量" )
    private Integer postLike=0;

    @ApiModelProperty(value ="文章来源" )
    private String postSource;

    @ApiModelProperty(value ="是否允许评论 0-是 1-否" )
    private String allowComment;

    @ApiModelProperty(value ="逻辑删除标记 0-正常 1-删除" )
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value ="创建时间" )
    private LocalDateTime createTime;

    @TableField(exist = false)
    @ApiModelProperty(value ="评论数量" )
    private Integer postComment;

}
