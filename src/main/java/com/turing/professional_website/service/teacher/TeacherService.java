package com.turing.professional_website.service.teacher;

import com.turing.professional_website.entity.Teacher;

/**
 * @author Jack
 * @date 2019-06-26-17:48
 */
public interface TeacherService {

    public Teacher findTeacherById(Integer id);

    public Teacher login(String username, String password);

    public boolean updateTeacherById(Teacher teacher);
}
