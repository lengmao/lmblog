package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.busi.entity.Post;

/**
 * 文章信息表 服务类
 * @author xus
 * @since 2019-11-12
 */
public interface PostService extends IService<Post> {

    /**
     * 管理员查看所有文章分页
     * @param page
     * @param post
     * @return
     */
    IPage pageAll(IPage<Post> page, Post post);

    /**
     * 首页展示的文章
     * @param page
     * @return
     */
    IPage pageHome(IPage<Post> page);

    /**
     * 用户首页展示文章
     * @param page
     * @return
     */
    IPage pageUser(IPage<Post> page);

    /**
     * 获取某个菜单下的文章
     * @param menuId
     * @return
     */
    IPage getPageByMenuId(IPage<Post> page,Integer menuId);

    /**
     * 获取某个标签下的文章
     * @param page
     * @param tagId
     * @return
     */
    IPage getPageByTagId(IPage<Post> page, Integer tagId);

    /**
     * 添加文章
     * @param post
     * @return
     */
    Boolean savePost(Post post);

    Boolean editPost(Post post);

    Boolean deletePost(Integer id);

    Post getPostById(Integer id);

    Boolean likeHandle(Integer id);
}
