package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.entity.Comment;
import com.blog.lm.busi.entity.Post;
import com.blog.lm.busi.mapper.PostMapper;
import com.blog.lm.busi.service.CommentService;
import com.blog.lm.busi.service.PostService;
import com.blog.lm.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章信息表 服务实现类
 *
 * @author xus
 * @since 2019-11-12
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    SysUserService userService;
    @Autowired
    CommentService commentService;

    @Override
    public IPage pageAll(IPage<Post> page, Post post) {
        IPage<Post> iPage = baseMapper.pageAll(page, post);
        iPage.getRecords().stream().forEach(p -> {
            List<Comment> comments = commentService.list(Wrappers.<Comment>query().lambda().eq(Comment::getPostId, p.getId()));
            p.setPostComment(comments.size());
        });
        return iPage;
    }

    @Override
    public IPage pageHome(IPage<Post> page) {
        IPage<Post> iPage = baseMapper.pageHome(page);
        iPage.getRecords().stream().forEach(p -> {
            List<Comment> comments = commentService.list(Wrappers.<Comment>query().lambda().eq(Comment::getPostId, p.getId()));
            p.setPostComment(comments.size());
        });
        return iPage;
    }

    @Override
    public IPage pageUser(IPage<Post> page) {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = userService.getUserByName(userName).getSysUser().getId();
        IPage<Post> iPage = baseMapper.pageUser(page, userId);
        iPage.getRecords().stream().forEach(p -> {
            List<Comment> comments = commentService.list(Wrappers.<Comment>query().lambda().eq(Comment::getPostId, p.getId()));
            p.setPostComment(comments.size());
        });
        return iPage;
    }

    @Override
    public IPage getPageByMenuId(IPage<Post> page, Integer menuId) {
        IPage<Post> iPage = baseMapper.getPageByMenuId(page, menuId);
        iPage.getRecords().stream().forEach(p -> {
            List<Comment> comments = commentService.list(Wrappers.<Comment>query().lambda().eq(Comment::getPostId, p.getId()));
            p.setPostComment(comments.size());
        });
        return iPage;
    }

    @Override
    public IPage getPageByTagId(IPage<Post> page, Integer tagId) {
        IPage<Post> iPage = baseMapper.getPageByTagId(page, tagId);
        iPage.getRecords().stream().forEach(p -> {
            List<Comment> comments = commentService.list(Wrappers.<Comment>query().lambda().eq(Comment::getPostId, p.getId()));
            p.setPostComment(comments.size());
        });
        return iPage;
    }

    @Override
    public Boolean savePost(Post post) {
        Integer userId = userService.getCurrentUser().getId();
        if (post.getUserId().equals(userId)) {
            post.setPostStatus("1");
            return this.save(post);
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean editPost(Post post) {
        Integer userId = userService.getCurrentUser().getId();
        if (null != post.getId() && post.getUserId().equals(userId)) {
            return this.updateById(post);
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deletePost(Integer id) {
        Integer userId = userService.getCurrentUser().getId();
        Post post = this.getById(id);
        if (post.getUserId().equals(userId)) {
            return this.removeById(id);
        }
        return Boolean.FALSE;
    }

    @Override
    public Post getPostById(Integer id) {
        Post post = this.getById(id);
        post.setPostView(+1);
        this.updateById(post);
        return this.getById(id);
    }

    @Override
    public Boolean likeHandle(Integer id) {
        Post post = this.getById(id);
        post.setPostLike(+1);
        this.updateById(post);
        return Boolean.TRUE;
    }
}
