package com.turing.professional_website.controller.guest;

import com.turing.professional_website.dao.CourseMapper;
import com.turing.professional_website.entity.Course;
import com.turing.professional_website.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-13:27
 */
@RestController
@RequestMapping(value = "/guest")
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    @GetMapping(value = "/courses")
    public Msg findAllCourses(){
        List<Course> courses = courseMapper.selectByExample(null);
        return Msg.success().add("courses", courses);
    }

}
