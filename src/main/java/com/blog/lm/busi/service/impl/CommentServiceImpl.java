package com.blog.lm.busi.service.impl;

import com.blog.lm.busi.entity.Comment;
import com.blog.lm.busi.mapper.CommentMapper;
import com.blog.lm.busi.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 评论信息表 服务实现类
 * @author xus
 * @since 2019-11-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
