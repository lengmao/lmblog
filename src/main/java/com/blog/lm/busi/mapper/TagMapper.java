package com.blog.lm.busi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 标签信息表 Mapper 接口
 *
 * @author xus
 * @since 2019-11-12
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    IPage pageAll(IPage<Tag> page, Tag tag);

    IPage pageUser(IPage<Tag> page, @Param("tag") Tag tag, @Param("userId") Integer userId);
}
