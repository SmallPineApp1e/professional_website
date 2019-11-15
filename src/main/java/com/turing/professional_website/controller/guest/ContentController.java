package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.Content;
import com.turing.professional_website.service.guest.ContentService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "获取内容", notes = "注意传递的属性名")
    @ApiImplicitParam(name = "contentTypeId",value = "内容类型id号", dataType = "Integer", paramType = "path", required = true)
    @RequestMapping("/content/{contentTypeId}")
    public Msg findContentByContentTypeId(@PathVariable("contentTypeId") Integer contentTypeId){
        Content content=contentService.findContentByContentTypeId(contentTypeId);
        return Msg.success().add("content",content);
    }
}
