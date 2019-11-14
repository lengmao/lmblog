package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.entity.Tag;
import com.blog.lm.busi.mapper.TagMapper;
import com.blog.lm.busi.service.TagService;
import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 标签信息表 服务实现类
 *
 * @author xus
 * @since 2019-11-12
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    SysUserService userService;

    @Override
    public IPage pageAll(IPage<Tag> page, Tag tag) {
        return baseMapper.pageAll(page, tag);
    }

    @Override
    public IPage pageUser(IPage<Tag> page, Tag tag) {
        SysUser user = userService.getCurrentUser();
        return baseMapper.pageUser(page, tag, user.getId());
    }

    @Override
    public Boolean saveTag(Tag tag) {
        SysUser user = userService.getCurrentUser();
        if (tag.getUserId().equals(user.getId())) {
            return this.save(tag);
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean editTag(Tag tag) {
        SysUser user = userService.getCurrentUser();
        if (null != tag.getId() && tag.getUserId().equals(user.getId())) {
            return this.updateById(tag);
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteTag(Integer id) {
        return this.removeById(id);
    }
}
