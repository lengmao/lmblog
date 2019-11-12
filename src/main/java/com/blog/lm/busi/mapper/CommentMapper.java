package com.blog.lm.busi.mapper;

import com.blog.lm.busi.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论信息表 Mapper 接口
 *
 * @author xus
 * @since 2019-11-12
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
