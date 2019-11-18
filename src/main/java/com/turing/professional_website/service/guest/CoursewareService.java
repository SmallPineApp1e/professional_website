package com.turing.professional_website.service.guest;

import com.turing.professional_website.entity.Courseware;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-12:54
 */
public interface CoursewareService {

    List<Courseware> findCoursewaresByCourseIdAndContentType(Integer courseId, Integer contentTypeId);
}
