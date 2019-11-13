package com.blog.lm.busi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 文章信息表 Mapper 接口
 *
 * @author xus
 * @since 2019-11-12
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

    IPage pageAll(IPage<Post> page, @Param("post") Post post);

    IPage pageHome(IPage<Post> page);

    IPage pageUser(IPage<Post> page, @Param("userId") Integer userId);

    IPage getPageByMenuId(IPage<Post> page, @Param("menuId") Integer menuId);

    IPage getPageByTagId(IPage<Post> page, @Param("tagId") Integer tagId);
}
