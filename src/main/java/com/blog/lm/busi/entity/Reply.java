package com.blog.lm.busi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论回复表
 * </p>
 *
 * @author xus
 * @since 2019-11-13
 */
@Data
@TableName("busi_reply")
public class Reply implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 回复目标id
     */
    private Integer replyId;

    /**
     * 回复类型 1 针对评论回复 2 针对回复回复
     */
    private Integer replyType;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复用户id
     */
    private Integer fromUid;

    /**
     * 目标用户id
     */
    private Integer toUid;

    /**
     * 0-已审核 1-待审核  2-未审核
     */
    private String replyStatus;

    /**
     * 回复时间
     */
    private LocalDateTime createTime;

    /**
     * 0正常 2删除
     */
    @TableLogic
    private String delFlag;


}
