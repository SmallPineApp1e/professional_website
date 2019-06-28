package com.turing.professional_website.controller.admin;

import com.turing.professional_website.entity.TeachBackground;
import com.turing.professional_website.service.admin.AdminTeachBackgroundService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jack
 * @date 2019-06-27-21:46
 */
@RestController
@ResponseBody
@RequestMapping("/teacher/teachBack")
@Api(tags = "后台教师教育背景管理接口")
public class AdminTeachBackgrounController {

    @Autowired
    AdminTeachBackgroundService adminTeachBackgroundService;

    @ApiOperation(value = "添加背景信息", notes = "注意实体类的属性名和时间的格式")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "backgroundId", value = "教育背景id号(自动生成)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "backgroundStartTime", value = "教育背景起始时间(yyyy-MM)", dataType = "date", paramType = "query", required = true),
            @ApiImplicitParam(name = "backgroundEndTime", value = "教育背景终止时间(yyyy-MM)", dataType = "date", paramType = "query", required = true),
            @ApiImplicitParam(name = "backgroundContent", value = "教育背景内容", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "teacherId", value = "教师的id", dataType = "int", paramType = "query", required = true)
    })
    /**
     * 添加教育背景信息
     * @param teachBackground
     * @return
     */
    @PostMapping(value = "")
    public Msg insertBackground(TeachBackground teachBackground){

        boolean addSuccess = adminTeachBackgroundService.addTeachBackground(teachBackground);
        if(addSuccess){
            return Msg.success();
        }else{
            return Msg.fail();
        }

    }

    /**
     * 根据id删除教育背景信息
     * @param id 教育背景的id号
     * @return
     */
    @ApiOperation(value = "删除教育背景信息", notes = "注意id跟在路径后面")
    @ApiImplicitParam(name = "id", value = "删除的背景信息id号", dataType = "int", paramType = "query", required = true)
    @DeleteMapping(value = "/{id}")
    public Msg deleteBackground(@PathVariable Integer id){
        boolean delSuccess = adminTeachBackgroundService.delTeachBackground(id);
        if(delSuccess){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

}
