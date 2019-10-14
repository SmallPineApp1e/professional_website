package com.turing.professional_website.service.admin;

import com.turing.professional_website.entity.Teacher;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jack
 * @date 2019-06-26-17:48
 */
public interface AdminService {

    public Teacher findTeacherById(Integer id);

    public Teacher login(String username, String password);

    public boolean updateTeacherById(Integer id, Teacher teacher);

    public boolean updateTeacherIconById(Integer id, MultipartFile img);

    public boolean updatePassword(HttpServletRequest request, Integer id, String oldPassword, String newPassword);

    boolean addTeacher(Teacher teacher);
}
