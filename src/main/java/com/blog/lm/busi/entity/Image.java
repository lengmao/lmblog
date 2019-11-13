package com.blog.lm.busi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("busi_image")
public class Image implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 文章id
     */
    private Integer postId;

    /**
     * 图片名称
     */
    private String imgName;

    /**
     * 类型: 1、公共资源2、博客文章3、用户资源
     */
    private String imgType;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 图片后缀
     */
    private String suffix;

    /**
     * 图片大小
     */
    private Long size;

    /**
     * 图片宽度
     */
    private Double width;

    /**
     * 图片高度
     */
    private Double height;

    /**
     * 0正常 1删除
     */
    @TableLogic
    private String delFlg;

    /**
     * 上传时间
     */
    private LocalDateTime createTime;


}
