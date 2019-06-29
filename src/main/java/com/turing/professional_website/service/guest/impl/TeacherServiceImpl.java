package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.AwardMapper;
import com.turing.professional_website.dao.TeachBackgroundMapper;
import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.*;
import com.turing.professional_website.service.guest.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-06-28-16:30
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    TeachBackgroundMapper teachBackgroundMapper;
    @Autowired
    AwardMapper awardMapper;

    @Override
    public List<Teacher> findAllTeachers() {

        List<Teacher> teachers = teacherMapper.selectByExample(null);
        return teachers;

    }

    @Override
    public Teacher findTeacherInfo(Integer teacherId) {

        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeacherIdEqualTo(teacherId);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if(teachers.size()!=0){
            Teacher teacher = teachers.get(0);
            //获取背景信息
            TeachBackgroundExample teachBackgroundExample = new TeachBackgroundExample();
            teachBackgroundExample.createCriteria().andTeacherIdEqualTo(teacher.getTeacherId());
            List<TeachBackground> teachBackgrounds = teachBackgroundMapper.selectByExample(teachBackgroundExample);
            teacher.setTeachBackgrounds(teachBackgrounds);
            //获取获奖情况
            AwardExample awardExample = new AwardExample();
            awardExample.createCriteria().andTeacherIdEqualTo(teacher.getTeacherId());
            List<Award> awards = awardMapper.selectByExample(awardExample);
            teacher.setAwards(awards);
            return teacher;
        }else{
            return null;
        }

    }
}
