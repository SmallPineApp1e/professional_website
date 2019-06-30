package com.turing.professional_website;

import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.Teacher;
import com.turing.professional_website.entity.TeacherExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfessionalWebsiteApplicationTests {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void contextLoads() {

        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeacherIdEqualTo(2);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        String old_photo = teachers.get(0).getTeacherImg();
        System.out.println(old_photo.substring(old_photo.lastIndexOf("/")+1));

    }

}
