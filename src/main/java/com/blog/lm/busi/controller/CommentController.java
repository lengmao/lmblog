package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.entity.Comment;
import com.blog.lm.busi.service.CommentService;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 评论信息表 接口
 * @author xus
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/admin/comment")
@AllArgsConstructor
@Api(tags = "评论")
public class CommentController {
    private final CommentService commentService;

    /**
     * 根据文章id查询所有评论
     * @param page
     * @param postId
     * @return
     */
    @GetMapping("/getCommentByPostId")
    @ApiOperation(value = "根据文章id查询所有评论", notes="根据文章id查询所有评论")
        public JsonResult getCommentByPostId(Page page,@RequestParam("postId") Integer postId){
            return new JsonResult(Boolean.TRUE, ResultCode.SUCCESS,commentService.getCommentByPostId(page,postId));
        }

    /**
     * 评论文章
     * @param comment
     * @return
     */
    @PostMapping("/insertComment")
    @ApiOperation(value = "评论文章", notes="评论文章")
        public JsonResult insertComment(@RequestBody Comment comment){
        if (comment==null){
            return new JsonResult(Boolean.FALSE,ResultCode.PARAM_IS_BLANK);
        }
        if (comment.getPostId()==null){
            return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_COMPLETE);
        }
        if (comment.getCommentContent().isEmpty()||comment.getCommentContent().length()<0){
            return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL,"评论不能为空");
        }
        return commentService.insertComment(comment);
        }

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @DeleteMapping("/delComment")
    @ApiOperation(value = "删除评论", notes="删除评论")
        public JsonResult delComment(Integer commentId){
        return commentService.delComment(commentId);
        }
}

