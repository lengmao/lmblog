package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Post;
import com.blog.lm.busi.service.PostService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章信息表 前端控制器
 * @author xus
 * @since 2019-11-12
 */
@RestController
public class PostController {

    @Autowired
    PostService postService;

    /**
     * 管理员查看所有文章
     * @return
     */
    @GetMapping("/post/pageAll")
    @PreAuthorize("@pms.hasPermission('post_page_all')")
    public JsonResult pageAll(IPage<Post> page,Post post){
        return new JsonResult(postService.pageAll(page,post));
    }

    /**
     * 首页展示的文章
     * 查询规则如下：
     * 1、最新创建的文章
     * 2、阅读量最多文章
     * 3、点赞量最多的文章
     * @return
     */
    @GetMapping("/api/homePost")
    public JsonResult pageHome(IPage<Post> page){

        return new JsonResult(postService.pageHome(page));
    }

    @GetMapping("/post/{userId}")
    public JsonResult pageUser(IPage<Post> page, @PathVariable Integer userId){
        return null;
    }

}

