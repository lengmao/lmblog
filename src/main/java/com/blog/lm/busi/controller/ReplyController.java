package com.blog.lm.busi.controller;


import com.blog.lm.busi.entity.Reply;
import com.blog.lm.busi.service.ReplyService;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论回复表 前端控制器
 * </p>
 *
 * @author xus
 * @since 2019-11-13
 */
@RestController
@RequestMapping("/busiReply")
@AllArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    /**
     * 回复
     */
    @PostMapping("/innsertReply")
    public JsonResult innsertReply(@RequestBody Reply reply){
        if (reply==null){
            return new JsonResult(Boolean.FALSE, ResultCode.PARAM_IS_BLANK);
        }
        if (reply.getReplyContent()==null||reply.getReplyContent().length()<0){
            return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL,"回复内容不能为空");
        }
        return replyService.innsertReply(reply);
    }
}

