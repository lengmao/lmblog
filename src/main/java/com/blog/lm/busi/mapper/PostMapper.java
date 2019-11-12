package com.blog.lm.busi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.lm.busi.entity.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章信息表 Mapper 接口
 *
 * @author xus
 * @since 2019-11-12
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
