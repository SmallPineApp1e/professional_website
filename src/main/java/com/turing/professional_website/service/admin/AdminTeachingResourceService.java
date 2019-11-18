package com.turing.professional_website.service.admin;

import com.turing.professional_website.entity.ContentType;
import com.turing.professional_website.entity.Course;
import com.turing.professional_website.entity.Courseware;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-16-18:34
 */
public interface AdminTeachingResourceService {

    List<Courseware> findCoursewareByCourseIdAndContentTypeId(Integer courseId, Integer contentTypeId);

    boolean uploadCoursewares(Integer courseId, Integer contentTypeId, MultipartFile[] coursewares);

    boolean uploadPDFByCourIdAndTypeId(Integer courseId, Integer contentTypeId, MultipartFile file);

    List<Course> findAllCourses();

    List<ContentType> findAllContentTypeInTeachingResource();

    boolean deletePowerpoint(Integer coursewareIds);

}
