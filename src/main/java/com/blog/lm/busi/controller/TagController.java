package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Tag;
import com.blog.lm.busi.service.TagService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签信息表 前端控制器
 * @author xus
 * @since 2019-11-12
 */
@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/api/tag/pageAll")
    public JsonResult pageAll(IPage<Tag> page,Tag tag){
        return new JsonResult(tagService.pageAll(page,tag));
    }

}

