package com.blog.lm.busi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.lm.common.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论信息表 Mapper 接口
 *
 * @author xus
 * @since 2019-11-12
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    IPage getCommentByPostId(Page page, @Param("id") Integer postId);
}
