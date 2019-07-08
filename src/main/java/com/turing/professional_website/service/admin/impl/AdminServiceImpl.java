package com.turing.professional_website.service.admin.impl;

import com.turing.professional_website.dao.AdminMapper;
import com.turing.professional_website.dao.AwardMapper;
import com.turing.professional_website.dao.TeachBackgroundMapper;
import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.*;
import com.turing.professional_website.service.admin.AdminService;
import com.turing.professional_website.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-06-26-17:48
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    AwardMapper awardMapper;
    @Autowired
    TeachBackgroundMapper teachBackgroundMapper;
    @Autowired
    AdminMapper adminMapper;
    @Value("${teacher.ImgPath}")
    String imgDir;
    @Autowired
    ImageUtil imageUtil;

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
    public boolean updateTeacherById(Integer id, Teacher teacher) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeacherIdEqualTo(id);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        //获取教师的图片
        String teacherImg = teachers.get(0).getTeacherImg();
        teacher.setTeacherImg(teacherImg);
        int row = teacherMapper.updateByExample(teacher, teacherExample);
        return (row != 0);
    }

    @Override
    public boolean updateTeacherIconById(Integer id, MultipartFile img) {

        Teacher teacher = null;
        //判断是否图片
        if (imageUtil.isPhoto(img)){
            //获取数据库中教师目前的头像, 判断是否为同一张头像, 若是则不用更新
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andTeacherIdEqualTo(id);
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            teacher = teachers.get(0);
            String oldImg = teacher.getTeacherImg();
            //当前存在数据库的图片名字
            String oldImgName = oldImg.substring(oldImg.lastIndexOf("/")+1);
            //上传过来的文件名
            String newImgName = img.getOriginalFilename();
            //判断是否上传同一张照片
            if (!oldImgName.equals(newImgName)){
                //获取图片后缀名
                String suffix = imageUtil.getSuffix(img);
                //获取图片UUID唯一标识名
                String prefix = imageUtil.getUUIDName();
                //组合成新的文件名
                String fileName = prefix + suffix;
                //生成新的文件的绝对路径
                String fileRealPath = imgDir + fileName;
                //生成新的文件并上传
                File uploadFile = new File(fileRealPath);
                try {
                    imageUtil.uploadPhoto(img, uploadFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                teacher.setTeacherImg("/static/icon/"+fileName);
            }else{
                teacher.setTeacherImg(oldImg);
            }
            int row = teacherMapper.updateByExample(teacher, teacherExample);
            return (row != 0);
        }else{
            //不是图片
            return false;
        }
    }
}
