package com.blog.lm.busi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.busi.entity.Tag;

/**
 * 标签信息表 服务类
 *
 * @author xus
 * @since 2019-11-12
 */
public interface TagService extends IService<Tag> {

    IPage pageAll(IPage<Tag> page, Tag tag);


}
