package com.turing.professional_website.controller.admin;

import com.turing.professional_website.entity.Award;
import com.turing.professional_website.service.admin.AdminAwardService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jack
 * @date 2019-06-27-21:55
 */
@RestController
@RequestMapping(value = "/teacher/award")
@Api(tags = "后台教师获奖情况管理接口")
public class AdminAwardController {

    @Autowired
    AdminAwardService adminAwardService;

    @ApiOperation(value = "添加获奖信息", notes = "注意实体类的属性名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "awardsId", value = "获奖id号(自动生成)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "awardsTime", value = "获奖时间,只要传年份", dataType = "date", paramType = "query", required = true),
            @ApiImplicitParam(name = "awardsName", value = "获奖名字", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "teacherId", value = "教师的id", dataType = "int", paramType = "query", required = true)
    })
    @PostMapping(value = "")
    public Msg addAwardService(Award award) {
        boolean addSuccess = adminAwardService.addAward(award);
        if (addSuccess) {
            return Msg.success();
        } else {
            return Msg.fail();
        }

    }

    @ApiOperation(value = "删除获奖信息", notes = "注意id跟在路径后面")
    @ApiImplicitParam(name = "id", value = "删除的获奖id号", dataType = "int", paramType = "query", required = true)
    @DeleteMapping(value = "/{id}")
    public Msg delAwardService(@PathVariable Integer id) {

        boolean delSuccess = adminAwardService.delAward(id);
        if (delSuccess) {
            return Msg.success();
        } else {
            return Msg.fail();
        }

    }

}
