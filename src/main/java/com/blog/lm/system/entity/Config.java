package com.blog.lm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_config")
public class Config {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String variable;
    @TableLogic
    private String delFlg;
}
