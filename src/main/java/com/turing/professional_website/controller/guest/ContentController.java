package com.turing.professional_website.controller.guest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.service.guest.ContentService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meng
 * @date 2019/11/14
 */
@RestController
@RequestMapping(value = "/guest")
@Api(tags = "前台获取内容信息接口")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @ApiOperation(value = "根据内容类型获取内容", notes = "注意传递的属性名")
    @ApiImplicitParam(name = "contentTypeId",value = "内容类型id号", dataType = "Integer", paramType = "path", required = true)
    @RequestMapping("/content/{contentTypeId}")
    public Msg findContentByContentTypeId(@PathVariable("contentTypeId") Integer contentTypeId){
        Content content=contentService.findContentByContentTypeId(contentTypeId);
        return Msg.success().add("content",content);
    }

    @ApiOperation(value = "根据类型id查找资料，查多个", notes = "根据类型id查找资料，查多个")
    @ApiImplicitParam(name = "contentTypeId", value = "内容类型Id", paramType = "query", dataType = "int", required = true)
    @GetMapping(value = "contents/{contentTypeId}")
    public Msg findContentsByContentTypeId(@PathVariable("contentTypeId") Integer contentTypeId){
        List<Content> contents=contentService.findContentsByContentTypeId(contentTypeId);
        return Msg.success().add("contents",contents);
    }

    @ApiOperation(value = "根据id获取内容", notes = "注意传递的属性名")
    @ApiImplicitParam(name = "id",value = "内容id号", dataType = "Integer", paramType = "path", required = true)
    @RequestMapping("/content")
    public Msg findContentById(@RequestParam("id") Integer id){
        Content content=contentService.findContentById(id);
        return Msg.success().add("content",content);
    }

    @ApiOperation(value = "根据类型id获取多内容。带分页,时间倒序", notes = "注意传递的属性名")
    @ApiImplicitParam(name = "contentTypeId",value = "内容类型id号", dataType = "Integer", paramType = "path", required = true)
    @RequestMapping("/contents")
    public Msg findContentsByContentTypeId(@RequestParam("contentTypeId") Integer contentTypeId,@RequestParam(value="pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,15);
        List<Content> contents=contentService.findContentsById(contentTypeId);
        PageInfo<Content> pageinfo=new PageInfo<>(contents,5);
        return Msg.success().add("pageinfo",pageinfo);
    }
}
