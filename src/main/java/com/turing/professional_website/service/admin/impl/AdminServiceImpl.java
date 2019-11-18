package com.turing.professional_website.service.admin.impl;

import com.turing.professional_website.dao.AdminMapper;
import com.turing.professional_website.dao.TeachBackgroundMapper;
import com.turing.professional_website.dao.TeacherMapper;
import com.turing.professional_website.entity.*;
import com.turing.professional_website.service.admin.AdminService;
import com.turing.professional_website.util.ImageUtil;
import com.turing.professional_website.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Jack
 * @date 2019-06-26-17:48
 */

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    TeacherMapper teacherMapper;
//    @Autowired
//    AwardMapper awardMapper;
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

        TeachBackgroundExample teachBackgroundExample = new TeachBackgroundExample();
        teachBackgroundExample.createCriteria().andTeacherIdEqualTo(id);
        List<TeachBackground> teachBackgrounds = teachBackgroundMapper.selectByExample(teachBackgroundExample);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if(teachers.isEmpty()){
            return null;
        }else{
            teachers.get(0).setTeachBackgrounds(teachBackgrounds);
            return teachers.get(0);
        }

    }

    @Override
    public Teacher login(String username, String password) {

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(MD5Util.getHexPassword(password));
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
                    System.out.println(imgDir+imageUtil.getFileName(teacher.getTeacherImg()));
                    imageUtil.deletePhoto(imageUtil.getFileName(teacher.getTeacherImg()));
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

    @Override
    public boolean updatePassword(HttpServletRequest request, Integer id, String oldPassword, String newPassword) {

        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andTeacherIdEqualTo(id);
        //获取MD5加密后的原始密码
        String hexOldPassword = MD5Util.getHexPassword(oldPassword);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size()!=0){
            Admin admin = admins.get(0);
            //密码比对
            if(admin.getPassword().equals(hexOldPassword)){
                String hexNewPassword = MD5Util.getHexPassword(newPassword);
                //设置新密码
                admin.setPassword(hexNewPassword);
                //更新管理员密码
                int row = adminMapper.updateByExample(admin, adminExample);
                if(row != 0){
                    request.getSession().removeAttribute("teacher");
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        teacher.setTeacherImg("/static/icon/1.png");
        int row = teacherMapper.insert(teacher);
        teacher.getTeachBackgrounds().forEach(teachBackground -> {
            teachBackground.setTeacherId(teacher.getTeacherId());
            teachBackgroundMapper.insert(teachBackground);
        });
        return row != 0;

    }

    @Override
    public List<Teacher> getTeachers() {
        TeacherExample teacherExample=new TeacherExample();
        return teacherMapper.selectByExample(teacherExample);
    }
}
