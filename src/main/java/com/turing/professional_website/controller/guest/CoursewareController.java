package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.Courseware;
import com.turing.professional_website.service.guest.CoursewareService;
import com.turing.professional_website.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-12:57
 */
@RestController
@RequestMapping(value = "/guest")
public class CoursewareController {

    @Autowired
    CoursewareService coursewareService;

    @GetMapping(value = "/courseware")
    public Msg findCoursewaresByCourseIdAndContentType(
            @RequestParam(name = "courseId") Integer courseId,
            @RequestParam(name = "contentTypeId") Integer contentTypeId){

        List<Courseware> coursewares = coursewareService.findCoursewaresByCourseIdAndContentType(courseId, contentTypeId);
        return Msg.success().add("coursewares", coursewares);

    }

}
