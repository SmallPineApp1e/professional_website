package com.turing.professional_website.controller.admin;

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
    public Msg findContentById(@PathVariable("contentTypeId") Integer contentTypeId){
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
}
