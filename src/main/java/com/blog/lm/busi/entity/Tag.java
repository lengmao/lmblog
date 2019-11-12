package com.blog.lm.busi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 标签信息表
 * @author xus
 * @since 2019-11-12
 */
@Data
public class Tag implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 标签所属用户ID
     */
    private Integer userId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 逻辑删除标记 0-正常 1-删除
     */
    private String delFlag;


}
