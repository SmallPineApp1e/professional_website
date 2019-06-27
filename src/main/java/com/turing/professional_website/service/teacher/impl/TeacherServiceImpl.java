package com.turing.professional_website.service.teacher.impl;

import com.turing.professional_website.dao.AdminMapper;
import com.turing.professional_website.dao.AwardMapper;
import com.turing.professional_website.dao.TeachBackgroundMapper;
import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.*;
import com.turing.professional_website.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-06-26-17:48
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    AwardMapper awardMapper;
    @Autowired
    TeachBackgroundMapper teachBackgroundMapper;
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Teacher findTeacherById(Integer id) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeacherIdEqualTo(id);
        AwardExample awardExample = new AwardExample();
        awardExample.createCriteria().andTeacherIdEqualTo(id);
        TeachBackgroundExample teachBackgroundExample = new TeachBackgroundExample();
        teachBackgroundExample.createCriteria().andTeacherIdEqualTo(id);
        List<TeachBackground> teachBackgrounds = teachBackgroundMapper.selectByExample(teachBackgroundExample);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        List<Award> awards = awardMapper.selectByExample(awardExample);
        if(teachers.isEmpty()){
            return null;
        }else{
            teachers.get(0).setAwards(awards);
            teachers.get(0).setTeachBackgrounds(teachBackgrounds);
            return teachers.get(0);
        }

    }

    @Override
    public Teacher login(String username, String password) {

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.isEmpty()){
            return null;
        }else{
            return this.findTeacherById(admins.get(0).getTeacherId());
        }

    }

    @Override
    public boolean updateTeacherById(Teacher teacher) {

        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeacherIdEqualTo(teacher.getTeacherId());
        int row = teacherMapper.updateByExample(teacher, teacherExample);
        return (row == 0);

    }
}
