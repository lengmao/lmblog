package com.blog.lm.busi.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.Comment;
import com.blog.lm.busi.mapper.CommentMapper;
import com.blog.lm.busi.mapper.ReplyMapper;
import com.blog.lm.busi.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.service.ReplyService;
import com.blog.lm.common.dto.CommentDto;
import com.blog.lm.common.dto.ReplyDto;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论信息表 服务实现类
 * @author xus
 * @since 2019-11-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private ReplyService replyService;
    @Override
    public IPage getCommentByPostId(Page page, Integer postId) {
        ArrayList<CommentDto> result = Lists.newArrayList();
        IPage commentByPostId = baseMapper.getCommentByPostId(page, postId);
         commentByPostId.getRecords().stream().forEach(item->{
             CommentDto commentDto = JSON.parseObject(JSON.toJSONString(item), CommentDto.class);
             commentDto.setReplyDto(replyService.getReplyByCommentId(commentDto.getId()));
             result.add(commentDto);
         });
        commentByPostId.setRecords(result);
        return commentByPostId;
    }
}
