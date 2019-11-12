package com.blog.lm.busi.controller;


import com.blog.lm.busi.entity.Image;
import com.blog.lm.busi.service.BusiImageService;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xus
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/busiImage")
@AllArgsConstructor
public class BusiImageController {
    @Autowired
    private UploadImgController uploadImgController;
    private final BusiImageService busiImageService;
    /**
     * 上传图片
     * @param file 图片
     * @param type 图片类型
     * @param postId 博客id
     * @param userId 用户id
     * @return
     */
    @PostMapping("/uploadImage")
    public JsonResult uploadImage(MultipartFile file, @RequestParam("type") String type, @RequestParam(value = "postId",required = false) Integer postId, @RequestParam(value = "userId",required = false) Integer userId){
        try {
            if (file.isEmpty()){
                return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_COMPLETE);
            }
            if (type.equals("2")&&postId==null){
                return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_COMPLETE);
            }
            if (type.equals("3")&&userId==null){
                return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_COMPLETE);
            }
            //文件名
            String originalFilename = file.getOriginalFilename();
            String fileName = originalFilename.substring(0,originalFilename.lastIndexOf("."));
            //文件后缀
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //获得文件大小
            long size = file.getSize();
            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read==null){
                return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_COMPLETE);
            }
            //宽度
            double height = read.getHeight();
            //高度
            double width = read.getWidth();
            //图片url
            String save = uploadImgController.save(file);
            String url = save.substring(0,save.lastIndexOf("."));
            Image image = new Image(null,userId,postId,fileName,type,url,substring,size,width,height,"0", LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
            return busiImageService.insertImage(image);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_COMPLETE);
    }

    /**
     * 删除图片
     * @param id 图片id
     * @param type 不传 默认为逻辑删除 1 为真实删除
     * @return
     */
    @DeleteMapping("/delImageById")
    public JsonResult delImageById(@RequestParam("id") Integer id,@RequestParam(value = "type",required = false) String type){
        if (id==null&&id<0){
            return new JsonResult(Boolean.FALSE,ResultCode.PARAM_NOT_VALID);
        }
       return busiImageService.delImageById(id,type);
    }
}

