package com.turing.professional_website.service.guest;

import com.turing.professional_website.entity.Teacher;

import java.util.List;

/**
 * @author Jack
 * @date 2019-06-28-16:30
 */
public interface TeacherService {

    /**
     * 获取所有教师
     * @return
     */
    public List<Teacher> findAllTeachers();

    /**
     * 获取教师详细信息
     * @return
     */
    public Teacher findTeacherInfo(String teacherName);

}
