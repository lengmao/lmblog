package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Post;
import com.blog.lm.busi.service.PostService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 文章信息表 前端控制器
 *
 * @author xus
 * @since 2019-11-12
 */
@RestController
public class PostController {

    @Autowired
    PostService postService;

    /**
     * 管理员查看所有文章
     *
     * @return
     */
    @GetMapping("/post/pageAll")
    @PreAuthorize("@pms.hasPermission('post_page_all')")
    public JsonResult pageAll(IPage<Post> page, Post post) {
        return new JsonResult(postService.pageAll(page, post));
    }

    /**
     * 首页展示的文章
     * 查询规则如下：
     * 1、最新创建的文章
     * 2、阅读量最多文章
     * 3、点赞量最多的文章
     *
     * @return
     */
    @GetMapping("/api/post/pageHome")
    public JsonResult pageHome(IPage<Post> page) {
        return new JsonResult(postService.pageHome(page));
    }

    /**
     * 通过菜单ID查询此菜单下所有的文章
     *
     * @param page
     * @param menuId
     * @return
     */
    @GetMapping("/api/post/getByMenuId/{menuId}")
    public JsonResult getPageByMenuId(IPage<Post> page, @PathVariable Integer menuId) {
        return new JsonResult(postService.getPageByMenuId(page, menuId));
    }

    /**
     * 通过标签ID获取此标签下的文章信息
     *
     * @param page
     * @param tagId
     * @return
     */
    @GetMapping("/api/post/getByTagId/{tagId}")
    public JsonResult getPageByTagId(IPage<Post> page, @PathVariable Integer tagId) {
        return new JsonResult(postService.getPageByTagId(page, tagId));
    }

    /**
     * 获取用户自己主页文章
     *
     * @param page
     * @return
     */
    @GetMapping("/post/pageUser")
    @PreAuthorize("@pms.hasPermission('post_page_user')")
    public JsonResult pageUser(IPage<Post> page) {
        return new JsonResult(postService.pageUser(page));
    }


    @PostMapping("/post/add")
    @PreAuthorize("@pms.hasPermission('post_add')")
    public JsonResult addPost(@RequestBody Post post) {
        return new JsonResult(postService.savePost(post));
    }

    @PutMapping("/post/edit")
    @PreAuthorize("@pms.hasPermission('edit_post')")
    public JsonResult editPost(@RequestBody Post post) {
        return new JsonResult(postService.editPost(post));
    }

    @DeleteMapping("/post/delete/{id}")
    @PreAuthorize("@pms.hasPermission('delete_post')")
    public JsonResult deletePost(@PathVariable Integer id) {
        return new JsonResult(postService.deletePost(id));
    }

    /**
     * 点击文章标题获取文章
     * @param id
     * @return
     */
    @GetMapping("/api/post/getById/{id}")
    public JsonResult getPostById(@PathVariable Integer id) {
        return new JsonResult(postService.getPostById(id));
    }

    /**
     * 点赞后更新文章点赞信息
     * @param id
     * @return
     */
    @GetMapping("/api/post/likeHandle/{id}")
    public JsonResult likeHandle(@PathVariable Integer id){
        return new JsonResult(postService.likeHandle(id));
    }

}

