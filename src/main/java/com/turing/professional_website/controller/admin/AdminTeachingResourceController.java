package com.turing.professional_website.controller.admin;

import com.turing.professional_website.entity.ContentType;
import com.turing.professional_website.entity.Course;
import com.turing.professional_website.entity.Courseware;
import com.turing.professional_website.service.admin.AdminTeachingResourceService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-16-18:29
 */
@Api(tags = "后台管理课程接口")
@RestController
@RequestMapping(value = "/admin")
public class AdminTeachingResourceController {

    @Autowired
    AdminTeachingResourceService adminTeachingResourceService;

    @GetMapping("/findByCourIdAndTypeId")
    public Msg findCoursewareByCourseIdAndContentTypeId(@RequestParam(name = "courseId") Integer courseId,
                                                        @RequestParam(name = "contentTypeId") Integer contentTypeId){
        List<Courseware> coursewares = adminTeachingResourceService.findCoursewareByCourseIdAndContentTypeId(courseId, contentTypeId);
        return Msg.success().add("coursewares", coursewares);
    }

    @GetMapping("/findAllCourses")
    public Msg findAllCourses(){
        List<Course> allCourses = adminTeachingResourceService.findAllCourses();
        return Msg.success().add("courses", allCourses);
    }
    @GetMapping("/findContentType")
    public Msg findAllContentTypeInTeachingResource(){
        List<ContentType> types = adminTeachingResourceService.findAllContentTypeInTeachingResource();
        return Msg.success().add("types", types);
    }

    @PostMapping("/course/pdf")
    public Msg uploadPdf(@RequestParam(value = "courseId") Integer courseId,
                         @RequestParam(value = "contentTypeId") Integer contentTypeId,
                         @RequestParam(value = "file") MultipartFile file){
        boolean uploadSuccess = adminTeachingResourceService.uploadPDFByCourIdAndTypeId(courseId, contentTypeId, file);
        return uploadSuccess ? Msg.success() : Msg.fail();
    }
    @PostMapping("/course/ppt")
    public Msg uploadPowerPoint(@RequestParam(value = "courseId") Integer courseId,
                                @RequestParam(value = "contentTypeId") Integer contentTypeId,
                                @RequestParam(value = "files") MultipartFile[] files){
        boolean uploadSuccess = adminTeachingResourceService.uploadCoursewares(courseId, contentTypeId, files);
        return uploadSuccess ? Msg.success() : Msg.fail();
    }

    @DeleteMapping("/course/deletePowerpoint")
    public Msg deletePowerPoint(@RequestParam(value = "coursewareId")Integer coursewareId){

        boolean deleteSuccess = adminTeachingResourceService.deletePowerpoint(coursewareId);

        return deleteSuccess ? Msg.success() : Msg.fail();

    }

}
