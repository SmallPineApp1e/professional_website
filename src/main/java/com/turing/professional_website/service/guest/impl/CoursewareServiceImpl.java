package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.CoursewareMapper;
import com.turing.professional_website.entity.Courseware;
import com.turing.professional_website.entity.CoursewareExample;
import com.turing.professional_website.service.guest.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-12:55
 */
@Service
public class CoursewareServiceImpl implements CoursewareService {

    @Autowired
    CoursewareMapper coursewareMapper;

    @Override
    public List<Courseware> findCoursewaresByCourseIdAndContentType(Integer courseId, Integer contentTypeId) {
        CoursewareExample coursewareExample = new CoursewareExample();
        coursewareExample.createCriteria().andContentTypeEqualTo(contentTypeId).andCourseIdEqualTo(courseId);
        List<Courseware> coursewares = coursewareMapper.selectByExample(coursewareExample);
        return coursewares;
    }

}
