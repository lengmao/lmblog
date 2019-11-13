package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.lm.busi.service.CommentService;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论信息表 接口
 * @author xus
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /**
     * 根据文章id查询所有评论
     * @param page
     * @param postId
     * @return
     */
    @GetMapping("/getCommentByPostId")
        public JsonResult getCommentByPostId(Page page,@RequestParam("postId") Integer postId){
            return new JsonResult(Boolean.TRUE, ResultCode.SUCCESS,commentService.getCommentByPostId(page,postId));
        }
}

