package com.blog.lm.busi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.lm.busi.entity.Reply;
import com.blog.lm.common.dto.ReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 评论回复表 Mapper 接口
 * </p>
 *
 * @author xus
 * @since 2019-11-13
 */
@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {
    /**
     * 查询评论下的回复
     * @param commentId
     * @return
     */
    List<ReplyDto> getReplyByCommentId(@Param("commentId") Integer commentId);

    /**
     * 查看回复下面的回复
     * @param replyId
     * @return
     */
    ReplyDto getReplyByReplyId(@Param("replyId")Integer replyId);
}
