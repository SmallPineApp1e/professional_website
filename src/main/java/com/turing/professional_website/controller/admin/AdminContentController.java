package com.turing.professional_website.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.service.admin.AdminContentService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Meng
 * @date 2019/11/16
 */
@ResponseBody
@RestController
@RequestMapping(value = "/admin")
@Api(tags = "后台内容信息接口")
public class AdminContentController {
    @Autowired
    private AdminContentService contentService;

    @ApiOperation(value = "根据id查找资料", notes = "根据id查找资料")
    @ApiImplicitParam(name = "contentTypeId", value = "内容类型Id", paramType = "query", dataType = "int", required = true)
    @GetMapping(value = "content/{contentTypeId}")
    public Msg findContentByContentTypeId(@PathVariable("contentTypeId") Integer contentTypeId){
        Content content=contentService.findContentByContentTypeId(contentTypeId);
        return Msg.success().add("content",content);
    }


    /**
     * 上传资料
     * @param contentTypeId
     * @param data
     * @return
     */
    @ApiOperation(value = "根据id修改资料", notes = "根据id修改资料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentTypeId", value = "内容类型Id", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "data", value = "资料", paramType = "query", dataType = "MultipartFile", required = true),
            @ApiImplicitParam(name="contentTitle",value="内容标题",paramType = "query",dataType = "String",required = true)
    })
    @PostMapping(value = "content")
    public Msg updateContentByContentTypeId(@RequestParam("contentTypeId")Integer contentTypeId,@RequestParam("contentTitle") String contentTitle, @RequestParam("data")MultipartFile data){
        boolean flag=contentService.updateDataById(contentTypeId,contentTitle,data);
        if(flag)return Msg.success();
        else return Msg.fail();
    }

    /**
     * 上传多个资料
     * @param contentTypeId
     * @param data
     * @return
     */
    @ApiOperation(value = "根据id修改资料", notes = "根据id修改资料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentTypeId", value = "内容类型Id", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "data", value = "资料", paramType = "query", dataType = "MultipartFile", required = true),
            @ApiImplicitParam(name="contentTitle",value="内容标题",paramType = "query",dataType = "String",required = true)
    })
    @PostMapping(value = "contents")
    public Msg updateContentsByContentTypeId(@RequestParam("contentTypeId")Integer contentTypeId,@RequestParam("contentTitle") String contentTitle, @RequestParam("data")MultipartFile[] data){
        boolean flag=contentService.updateContentsById(contentTypeId,contentTitle,data);
        if(flag)return Msg.success();
        else return Msg.fail();
    }

    @ApiOperation(value = "根据id查找资料，带分页", notes = "根据id查找资料，带分页")
    @ApiImplicitParam(name = "contentTypeId", value = "内容类型Id", paramType = "query", dataType = "int", required = true)
    @GetMapping(value = "content")
    public Msg findContentsById(@RequestParam("contentTypeId") Integer contentTypeId,@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,8);
        List<Content> contents=contentService.findContentsByContentTypeId(contentTypeId);
        PageInfo<Content> pageInfo=new PageInfo<>(contents,5);
        return Msg.success().add("pageinfo",pageInfo);
    }

    @ApiOperation(value = "根据内容id查找内容", notes = "根据内容id查找内容")
    @ApiImplicitParam(name = "id", value = "内容Id", paramType = "query", dataType = "int", required = true)
    @GetMapping(value = "content/content/{id}")
    public Msg findContentById(@PathVariable("id") Integer id){
        Content content=contentService.findContentById(id);
        return Msg.success().add("content",content);
    }

    @ApiOperation(value = "根据类型id添加文本内容", notes = "根据类型id添加文本内容")

    @PostMapping(value = "content/content")
    public Msg saveContent(Content content){
        contentService.saveContent(content);
        return Msg.success().add("content",content);
    }

    @ApiOperation(value = "根据内容id删除内容", notes = "根据内容id删除内容")
    @ApiImplicitParam(name = "id", value = "内容Id", paramType = "query", dataType = "int", required = true)
    @DeleteMapping(value = "content/{id}")
    public Msg deleteContentById(@PathVariable("id") Integer id){
        contentService.deleteContentById(id);
        return Msg.success();
    }
    @ApiOperation(value = "根据内容id更新内容", notes = "根据内容更新内容")
    @ApiImplicitParam(name = "id", value = "内容Id", paramType = "query", dataType = "int", required = true)
    @PutMapping(value = "content")
    public Msg updateContentById(Content content){
        contentService.updateContentById(content);
        return Msg.success();
    }

}
