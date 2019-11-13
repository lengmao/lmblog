package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.common.dto.CommentDto;

import java.util.List;

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
}
