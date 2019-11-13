package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.busi.entity.Reply;
import com.blog.lm.common.dto.ReplyDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论回复表 服务类
 * </p>
 *
 * @author xus
 * @since 2019-11-13
 */
public interface ReplyService extends IService<Reply> {
    List<ReplyDto> getReplyByCommentId(@Param("commentId") Integer commentId);
}
