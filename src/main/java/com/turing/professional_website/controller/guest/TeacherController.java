package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.Teacher;
import com.turing.professional_website.service.guest.TeacherService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-06-28-16:29
 */
@RestController
@RequestMapping(value = "/guest")
@Api(tags = "前台获取教师信息接口")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @ApiOperation(value = "获取所有教师的名字+照片接口", notes = "照片名字就是拼接教师名字加图片后缀名")
    @GetMapping(value = "/teachers")
    public Msg findAllTeachers(){

        List<Teacher> teachers = teacherService.findAllTeachers();
        Msg msg = new Msg(200, "处理成功");
        msg.getExtended().put("teachers", teachers);
        return msg;

    }

    @ApiOperation(value = "获取教师详细信息", notes = "注意传递的属性名")
    @GetMapping(value = "/teacherInfo")
    public Msg findTeacherInfo(@RequestParam(name = "teacherName") String teacherName){

        Teacher teacher = teacherService.findTeacherInfo(teacherName);
        Msg msg = new Msg(200, "处理成功");
        msg.getExtended().put("teacher", teacher);
        return msg;

    }

}
