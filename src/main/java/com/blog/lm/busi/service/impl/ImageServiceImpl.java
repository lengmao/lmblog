package com.blog.lm.busi.service.impl;


import com.blog.lm.busi.service.UploadService;
import com.blog.lm.system.entity.Config;
import com.blog.lm.busi.entity.Image;
import com.blog.lm.busi.mapper.ImageMapper;
import com.blog.lm.busi.service.ImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import com.blog.lm.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现类
 *
 * @author xus
 * @since 2019-11-12
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {
    @Autowired
    private SysConfigService configService;
    @Autowired
    private UploadService UploadService;

    /**
     * 上传图片
     * @param image
     * @return
     */
    @Override
    @Transactional
    public JsonResult insertImage(Image image) {
        if (baseMapper.insert(image)>0){
            Config pictureServer = configService.getConfigurationByName("PictureServer");
            String url=pictureServer.getVariable()+"//"+image.getImgUrl()+"."+image.getSuffix();
            return new JsonResult(Boolean.TRUE,ResultCode.SUCCESS,url);
        }
        return new JsonResult(Boolean.FALSE,ResultCode.COMMON_FAIL);
    }

    /**
     * 删除图片
     * @param id
     * @param type
     * @return
     */
    @Transactional
    @Override
    public JsonResult delImageById(Integer id,String type) {
        Image image = baseMapper.selectById(id);
        if (type!=null){
            //删除服务器上面的图片
            UploadService.del(image.getImgUrl()+"."+image.getSuffix());
            baseMapper.deleteById(id);
            return new JsonResult(Boolean.TRUE,ResultCode.SUCCESS);
        }
        image.setDelFlg("1");
        baseMapper.updateById(image);
        return new JsonResult(Boolean.TRUE,ResultCode.SUCCESS);
    }
}
