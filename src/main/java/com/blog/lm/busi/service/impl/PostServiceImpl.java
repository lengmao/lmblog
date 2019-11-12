package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.entity.Post;
import com.blog.lm.busi.mapper.PostMapper;
import com.blog.lm.busi.service.PostService;
import org.springframework.stereotype.Service;

/**
 * 文章信息表 服务实现类
 * @author xus
 * @since 2019-11-12
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
