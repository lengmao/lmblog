package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.entity.Tag;
import com.blog.lm.busi.mapper.TagMapper;
import com.blog.lm.busi.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签信息表 服务实现类
 * @author xus
 * @since 2019-11-12
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public IPage pageAll(IPage<Tag> page, Tag tag) {
        return null;
    }
}
