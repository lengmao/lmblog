package com.blog.lm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("sys_config")
public class Config {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value ="主键" )
    private Integer id;
    @ApiModelProperty(value ="名称" )
    private String name;
    @ApiModelProperty(value ="值" )
    private String variable;
    @TableLogic
    @ApiModelProperty(value ="删除标志 0:正常 1:删除" )
    private String delFlg;
}
