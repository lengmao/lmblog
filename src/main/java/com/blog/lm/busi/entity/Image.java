package com.blog.lm.busi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.mockito.stubbing.ValidableAnswer;

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

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "文章id")
    private Integer postId;

    @ApiModelProperty(value = "图片名称")
    private String imgName;

    @ApiModelProperty(value = "类型: 1、公共资源2、博客文章3、用户资源")
    private String imgType;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;
    @ApiModelProperty(value = "图片后缀")
    private String suffix;

    @ApiModelProperty(value = "图片大小")
    private Long size;
    @ApiModelProperty(value = "图片宽度")
    private Double width;

    @ApiModelProperty(value = "图片高度")
    private Double height;

    @TableLogic
    @ApiModelProperty(value = "0正常 1删除")
    private String delFlg;

    @ApiModelProperty(value = "上传时间")
    private LocalDateTime createTime;


}
