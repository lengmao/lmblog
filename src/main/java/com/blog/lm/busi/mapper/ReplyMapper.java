package com.blog.lm.busi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.lm.busi.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论回复表 Mapper 接口
 * </p>
 *
 * @author xus
 * @since 2019-11-13
 */
@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {

}
