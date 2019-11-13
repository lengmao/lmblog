package com.blog.lm.busi.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.Comment;
import com.blog.lm.busi.mapper.CommentMapper;
import com.blog.lm.busi.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.service.ReplyService;
import com.blog.lm.common.dto.CommentDto;
import com.blog.lm.common.dto.ReplyDto;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.service.SysUserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SysUserService sysUserService;
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

    /**
     * 评论文章
     * @param comment
     * @return
     */
    @Override
    public JsonResult insertComment(Comment comment) {

        SysUser currentUser = sysUserService.getCurrentUser();
        if (currentUser==null){
            comment.setCommentType("0");
        }else {
            comment.setCommentType("1");
        }
        comment.setFromUid(currentUser.getId());
        int insert = baseMapper.insert(comment);
        if (insert>0){
            return new JsonResult(Boolean.TRUE, ResultCode.SUCCESS);
        }
        return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL);
    }

    @Override
    @Transactional
    public JsonResult delComment(Integer commentId) {
        //查询出当前评论下面的所有回复
        List<ReplyDto> replyByCommentId = replyService.getReplyByCommentId(commentId);
        replyByCommentId.stream().forEach(item->
        {
            replyService.delReply(commentId);
            if (item.getReplydto()!=null){
                replyService.delReply(item.getReplydto().getId());
            }
        }
        );
        baseMapper.deleteById(commentId);
        return new JsonResult();
    }
}
