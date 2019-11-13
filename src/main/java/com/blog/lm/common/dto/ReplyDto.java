package com.blog.lm.common.dto;

import com.blog.lm.busi.entity.Reply;
import lombok.Data;

@Data
public class ReplyDto extends Reply {
    private String fromName;
    private String fromAvatar;
    private String toName;
    private String toAvatar;
    private ReplyDto replydto;
}
