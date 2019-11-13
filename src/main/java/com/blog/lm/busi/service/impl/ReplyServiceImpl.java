package com.blog.lm.busi.service.impl;

import com.blog.lm.busi.entity.Reply;
import com.blog.lm.busi.mapper.ReplyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.service.ReplyService;
import com.blog.lm.common.dto.ReplyDto;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论回复表 服务实现类
 * </p>
 *
 * @author xus
 * @since 2019-11-13
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
    @Autowired
    private SysUserService sysUserService;
    @Override
    public List<ReplyDto> getReplyByCommentId(Integer commentId) {
        List<ReplyDto> replyByCommentId = baseMapper.getReplyByCommentId(commentId);
        replyByCommentId.stream().forEach(item->
            item.setReplydto(baseMapper.getReplyByReplyId(item.getId())));
        return replyByCommentId;
    }

    @Override
    public JsonResult innsertReply(Reply reply) {
        if (reply.getCommentId()!=null){
            reply.setReplyId(0);
            reply.setReplyType(1);
        }else {
            reply.setReplyType(2);
        }
        SysUser currentUser = sysUserService.getCurrentUser();
        if (currentUser==null){
            return new JsonResult(Boolean.FALSE,ResultCode.USER_NOT_LOGIN);
        }else {
            reply.setFromUid(currentUser.getId());
        }
        int insert = baseMapper.insert(reply);
        if (insert>0){
            return new JsonResult(Boolean.TRUE, ResultCode.SUCCESS);
        }
        return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL);
    }

    @Override
    public JsonResult delReply(Integer replyId) {
        int i = baseMapper.deleteById(replyId);
        if (i>0){
            return new JsonResult(Boolean.TRUE,ResultCode.SUCCESS);
        }
        return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL);
    }
}
