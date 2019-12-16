package com.blog.lm.busi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.lm.busi.entity.Tag;
import com.blog.lm.busi.service.TagService;
import com.blog.lm.common.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "标签信息表")
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
    @ApiOperation(value = "获取所有标签", notes="获取所有标签")
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
    @ApiOperation(value = "获取当前登录用户的标签", notes="获取当前登录用户的标签")
    public JsonResult pageUser(IPage<Tag> page, Tag tag) {
        return new JsonResult(tagService.pageUser(page, tag));
    }

    @PostMapping("/tag/add")
    @PreAuthorize("@pms.hasPermission('add_tag')")
    @ApiOperation(value = "添加标签", notes="添加标签")
    public JsonResult saveTag(@RequestBody Tag tag){
        return new JsonResult(tagService.saveTag(tag));
    }


    @PutMapping("/tag/edit")
    @PreAuthorize("@pms.hasPermission('edit_tag')")
    @ApiOperation(value = "修改标签", notes="修改标签")
    public JsonResult editTag(@RequestBody Tag tag){
        return new JsonResult(tagService.editTag(tag));
    }

    @DeleteMapping("tag/delete/{id}")
    @PreAuthorize("@pms.hasPermission('delete_tag')")
    @ApiOperation(value = "根据id删除标签", notes="根据id删除标签")
    public JsonResult deleteTag(@PathVariable Integer id){
        return new JsonResult(tagService.deleteTag(id));
    }

}

