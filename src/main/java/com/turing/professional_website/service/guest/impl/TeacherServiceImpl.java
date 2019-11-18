package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.TeachBackgroundMapper;
import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.*;
import com.turing.professional_website.service.guest.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
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

    @Value("${teacher.ImgPath}")
    private String ImgDir;

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
            return teacher;
        }else{
            return null;
        }

    }
}
