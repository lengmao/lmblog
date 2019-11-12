package com.blog.lm.busi.service;

import com.blog.lm.busi.entity.Image;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.lm.common.result.JsonResult;


/**
 *  图片服务类
 * @author xus
 * @since 2019-11-12
 */
public interface ImageService extends IService<Image> {
    /**
     * 上传图片
     * @param image
     * @return
     */
    JsonResult insertImage(Image image);

    /**
     * 根据图片id删除图片
     * @param id
     * @param type
     * @return
     */
    JsonResult delImageById(Integer id,String type);
}
