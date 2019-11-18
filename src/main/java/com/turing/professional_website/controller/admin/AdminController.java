package com.turing.professional_website.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

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
    @ApiOperation(value = "新增教师", notes = "暂无需注意的事项")
    @PostMapping("")
    public Msg addTeacher(@RequestBody Teacher teacher){

        boolean addSuccess = adminService.addTeacher(teacher);
        return addSuccess ? Msg.success() : Msg.fail();
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
    })
    @PutMapping(value = "/{id}")
    public Msg updateTeacherById(@PathVariable Integer id, Teacher teacher){

        boolean updateSuccess = adminService.updateTeacherById(id, teacher);
        if (updateSuccess) {
            return Msg.success();
        }else{
            return Msg.fail();
        }

    }

    /**
     * 根据id更新教师的头像
     * @param id 教师id
     * @param img 图片
     * @return
     */
    @ApiOperation(value = "根据id更新教师头像", notes = "文件上传的属性名称为img")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师id", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "img", value = "教师头像", paramType = "query", dataType = "MultipartFile", required = true,
            allowMultiple = true)
    })
    @PutMapping(value = "/icon/{id}")
    public Msg updateTeacherIconById(@PathVariable Integer id, @RequestParam(value = "img")MultipartFile img){
        boolean updateIconSuccess = adminService.updateTeacherIconById(id, img);
        return updateIconSuccess? Msg.success() : Msg.fail();
    }

    /**
     * 根据教师id修改密码
     * @param id 教师id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    @ApiOperation(value = "根据教师id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "id", value = "教师id", dataType = "Integer", paramType = "path", required = true)
    })
    @PutMapping(value = "/updatePass/{id}")
    public Msg updateAdminPassword(@PathVariable Integer id, @RequestParam(value = "oldPassword") String oldPassword,
                                   @RequestParam(value = "newPassword") String newPassword, HttpServletRequest request){

        boolean updateSuccess = adminService.updatePassword(request, id, oldPassword, newPassword);
        return updateSuccess? Msg.success().add("success", "密码修改成功!请重新登录"):Msg.fail().add("fail", "密码修改失败!");

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

    /**
     * 获取全部教师
     * @param pn 当前处在分页中的第几页
     * @return
     */
    @GetMapping(value = "/teacher")
    public Msg getTeachers(@RequestParam(value="pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Teacher> teachers=adminService.getTeachers();
        PageInfo<Teacher> pageInfo=new PageInfo<>(teachers,5);
        return Msg.success().add("pageinfo",pageInfo);
    }

}
