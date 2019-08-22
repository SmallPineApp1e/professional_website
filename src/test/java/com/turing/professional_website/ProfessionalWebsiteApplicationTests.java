package com.turing.professional_website;

import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.Teacher;
import com.turing.professional_website.entity.TeacherExample;
import com.turing.professional_website.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
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

    @Test
    public void delete(){
        File file=new File("D:\\upload\\img\\c26319a785764920.png");
        file.delete();
    }

    @Test
    public void md5(){
        String hexPassword = MD5Util.getHexPassword("mengjiahui");
        System.out.println(hexPassword);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }


    @Test
    public void test(){
        System.out.println(tableSizeFor(257));
    }

}
