package com.blog.lm.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_config")
public class Configuration {
    private Integer id;
    private String name;
    private String variable;
    private String delFlg;
}
