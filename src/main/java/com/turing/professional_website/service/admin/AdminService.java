package com.turing.professional_website.service.admin;

import com.turing.professional_website.entity.Teacher;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Jack
 * @date 2019-06-26-17:48
 */
public interface AdminService {

    Teacher findTeacherById(Integer id);

    Teacher login(String username, String password);

    boolean updateTeacherById(Integer id, Teacher teacher);

    boolean updateTeacherIconById(Integer id, MultipartFile img);

    boolean updatePassword(HttpServletRequest request, Integer id, String oldPassword, String newPassword);

    boolean addTeacher(Teacher teacher);

    List<Teacher> getTeachers();
}
