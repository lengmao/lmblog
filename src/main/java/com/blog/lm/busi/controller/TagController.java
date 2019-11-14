package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Tag;
import com.blog.lm.busi.service.TagService;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 标签信息表 前端控制器
 *
 * @author xus
 * @since 2019-11-12
 */
@RestController
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * 获取所有标签
     *
     * @param page
     * @param tag
     * @return
     */
    @GetMapping("/api/tag/pageAll")
    public JsonResult pageAll(IPage<Tag> page, Tag tag) {
        return new JsonResult(tagService.pageAll(page, tag));
    }

    /**
     * 获取当前登录用户的标签
     *
     * @param page
     * @param tag
     * @return
     */
    @GetMapping("/tag/pageUser")
    @PreAuthorize("@pms.hasPermission('tag_page_user')")
    public JsonResult pageUser(IPage<Tag> page, Tag tag) {
        return new JsonResult(tagService.pageUser(page, tag));
    }

    @PostMapping("/tag/add")
    @PreAuthorize("@pms.hasPermission('add_tag')")
    public JsonResult saveTag(@RequestBody Tag tag){
        return new JsonResult(tagService.saveTag(tag));
    }


    @PutMapping("/tag/edit")
    @PreAuthorize("@pms.hasPermission('edit_tag')")
    public JsonResult editTag(@RequestBody Tag tag){
        return new JsonResult(tagService.editTag(tag));
    }

    @DeleteMapping("tag/delete/{id}")
    @PreAuthorize("@pms.hasPermission('delete_tag')")
    public JsonResult deleteTag(@PathVariable Integer id){
        return new JsonResult(tagService.deleteTag(id));
    }

}

