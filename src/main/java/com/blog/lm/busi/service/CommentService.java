package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.common.result.JsonResult;

/**
 * 评论信息表 服务类
 * @author xus
 * @since 2019-11-12
 */
public interface CommentService extends IService<Comment> {
    /**
     * 根据文章id查询文章下面的所有评论
     * @param page
     * @param postId
     * @return
     */
    IPage getCommentByPostId(Page page, Integer postId);

    /**
     * 评论文章
     * @param comment
     * @return
     */
    JsonResult insertComment(Comment comment);

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    JsonResult delComment(Integer commentId);
}
