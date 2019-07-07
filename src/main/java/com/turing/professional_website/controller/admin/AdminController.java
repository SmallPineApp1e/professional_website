package com.turing.professional_website.controller.admin;

import com.turing.professional_website.entity.Teacher;
import com.turing.professional_website.service.admin.AdminService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jack
 * @date 2019-06-26-17:47
 */
@Api(tags = "后台管理教师信息接口")
@RestController
@ResponseBody
@CrossOrigin(allowCredentials="true",maxAge = 3600)
@RequestMapping(value = "/teacher")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Value("${teacher.ImgPath}")
    private String imgPath;

    /**
     * 根据id查询教师信息
     * @param id 教师id号
     * @return
     */
    @ApiOperation(value = "根据id查询教师信息", notes = "暂无需注意的事项")
    @ApiImplicitParam(name = "id", value = "教师id", paramType = "path", dataType = "int", required = true)
    @GetMapping(value = "/{id}")
    public Msg getTeacherById(@PathVariable Integer id, HttpServletResponse response) {

        Teacher teacher = adminService.findTeacherById(id);
        Msg msg = new Msg(200, "处理成功!");
        msg.add("teacher", teacher);
        return msg;

    }

    @ApiOperation(value = "根据id修改教师信息", notes = "id必须要在路径上, 另外教师的所有信息不能为空,奖项和教育背景是数组集合类型,")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师id", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "teacherName", value = "教师名字", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "teacherEmail", value = "教师邮箱", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "teacherBorn", value = "教师出生地", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "teacherJob", value = "教师职业", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "teacherGraduation", value = "教师毕业院校", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "teacherPosition", value = "教师职称", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "teacherResearch", value = "教师主要研究方向", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "teacherScientificResearch", value = "教师科研工作", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "teacherAwardIntroduction", value = "教师获奖主要介绍", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "img", value = "教师图片", paramType = "query", dataType = "file", required = false)
    })
    @PutMapping(value = "/{id}")
    public Msg updateTeacherById(@PathVariable Integer id, Teacher teacher, @RequestParam(value = "img") MultipartFile img){

        boolean updateSuccess = adminService.updateTeacherById(teacher, img);
        if (updateSuccess) {
            return Msg.success();
        }else{
            return Msg.fail();
        }

    }


    /**
     * 教师登陆接口
     * @param username  账号
     * @param password  密码
     * @param request
     * @return
     */
    @ApiOperation(value = "教师登陆接口", notes = "暂无需注意的事项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string", required = true)
    })
    @PostMapping(value = "/login")
    public Msg teacherLogin(@RequestParam(name = "username") String username,
                            @RequestParam(name = "password") String password,
                            HttpServletRequest request) {

        Teacher teacher = adminService.login(username, password);
        Msg msg = new Msg();
        if (teacher == null) {
            msg.setCode(100);
            msg.setMsg("登陆失败");
            msg.getExtended().put("error", "用户名或密码错误!");
            return msg;
        } else {
            msg.setCode(200);
            msg.setMsg("登陆成功");
            request.getSession().setAttribute("teacher", teacher);
            return msg;
        }
    }

    /**
     * 获取登陆的教师id
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "获取登陆的教师id", notes = "暂无")
    @GetMapping(value = "/getTeacherId")
    public Msg getTeacherId(HttpServletRequest request, HttpServletResponse response){

        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        return Msg.success().add("teacherId", teacher.getTeacherId());

    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/logout")
    public Msg logout(HttpServletRequest request){

        request.getSession().removeAttribute("teacher");
        Msg msg = new Msg(200, "登出成功!");
        return msg;

    }



}
