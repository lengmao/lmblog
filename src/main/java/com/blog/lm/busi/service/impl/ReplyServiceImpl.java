package com.blog.lm.busi.service.impl;

import com.blog.lm.busi.entity.Reply;
import com.blog.lm.busi.mapper.ReplyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.service.ReplyService;
import com.blog.lm.common.dto.ReplyDto;
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

    @Override
    public List<ReplyDto> getReplyByCommentId(Integer commentId) {
        return baseMapper.getReplyByCommentId(commentId);
    }
}
