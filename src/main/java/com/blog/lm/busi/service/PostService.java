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
}
