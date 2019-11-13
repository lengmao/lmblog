package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.busi.entity.Reply;
import com.blog.lm.common.dto.ReplyDto;
import com.blog.lm.common.result.JsonResult;
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
    /**
     * 根据评论id查询评论下的回复
     * @param commentId
     * @return
     */
    List<ReplyDto> getReplyByCommentId(@Param("commentId") Integer commentId);

    /**
     * 回复
     * @param reply
     * @return
     */
    JsonResult innsertReply(Reply reply);

    /**
     * 根据回复id删除回复
     * @param replyId
     * @return
     */
    JsonResult delReply(Integer replyId);
}
