package com.blog.lm.busi.service.impl;

import com.blog.lm.busi.entity.Configuration;
import com.blog.lm.busi.entity.Image;
import com.blog.lm.busi.mapper.BusiImageMapper;
import com.blog.lm.busi.service.BusiImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.service.BusilConfigurationService;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xus
 * @since 2019-11-12
 */
@Service
public class BusiImageServiceImpl extends ServiceImpl<BusiImageMapper, Image> implements BusiImageService {
    @Autowired
    private BusilConfigurationService busilConfigurationService;
    @Override
    @Transactional
    public JsonResult insertImage(Image image) {
        if (baseMapper.insert(image)>0){
            Configuration pictureServer = busilConfigurationService.getConfigurationByName("PictureServer");
            String url=pictureServer.getVariable()+"//"+image.getImgUrl()+"."+image.getSuffix();
            return new JsonResult(Boolean.TRUE,ResultCode.SUCCESS,url);
        }
        return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL);
    }
}
