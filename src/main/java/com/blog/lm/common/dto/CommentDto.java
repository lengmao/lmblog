package com.blog.lm.common.dto;


import com.blog.lm.busi.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto extends Comment {
    private List<ReplyDto> replyDto;
    private String userDisplayName;
    private String userAvatar;
}
