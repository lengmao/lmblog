package com.blog.lm.busi.service;

import com.blog.lm.busi.entity.Image;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.common.result.JsonResult;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xus
 * @since 2019-11-12
 */
public interface BusiImageService extends IService<Image> {
    JsonResult insertImage(Image image);
}
