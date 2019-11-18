package com.turing.professional_website.service.admin.impl;

import com.turing.professional_website.dao.ContentTypeMapper;
import com.turing.professional_website.dao.CourseMapper;
import com.turing.professional_website.dao.CoursewareMapper;
import com.turing.professional_website.entity.*;
import com.turing.professional_website.service.admin.AdminTeachingResourceService;
import com.turing.professional_website.util.PdfUtil;
import com.turing.professional_website.util.PowerPointUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @date 2019-11-16-18:34
 */
@Service
@Transactional
public class AdminTeachingResourceServiceImpl implements AdminTeachingResourceService {

    @Autowired
    CoursewareMapper coursewareMapper;
    @Autowired
    ContentTypeMapper contentTypeMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    private PowerPointUtil powerPointUtil;
    @Autowired
    private PdfUtil pdfUtil;
    @Value(value = "${powerPointPath}")
    private String powerPointPath;
    @Value("${pdfPath}")
    private String pdfPath;

    @Override
    public List<Courseware> findCoursewareByCourseIdAndContentTypeId(Integer courseId, Integer contentTypeId) {
        CoursewareExample coursewareExample = new CoursewareExample();
        coursewareExample.createCriteria().andCourseIdEqualTo(courseId).andContentTypeEqualTo(contentTypeId);
        List<Courseware> coursewares = coursewareMapper.selectByExample(coursewareExample);
        return coursewares;
    }

    @Override
    public boolean uploadCoursewares(Integer courseId, Integer contentTypeId, MultipartFile[] coursewares) {

        boolean flag = true;
        for (MultipartFile courseware : coursewares) {
            Courseware dbCourseware = new Courseware();
            dbCourseware.setContentType(contentTypeId);
            dbCourseware.setCourseId(courseId);
            if (!powerPointUtil.isPowerPoint(courseware)) {
                return false;
            }
            String coursewareName = courseware.getOriginalFilename();
            String newCoursewareAbsoluteName = powerPointPath + coursewareName;
            String newCoursewareRelativeName = "/static/ppt/" + coursewareName;
            dbCourseware.setCoursewareLoc(newCoursewareRelativeName);
            File coursewareFile = new File(newCoursewareAbsoluteName);
            try {
                powerPointUtil.uploadPowerPoint(courseware, coursewareFile);
                coursewareMapper.insert(dbCourseware);
            } catch (IOException e) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean uploadPDFByCourIdAndTypeId(Integer courseId, Integer contentTypeId, MultipartFile file) {
        if (!pdfUtil.isPdf(file)) {
            return false;
        }
        boolean flag = true;
        String prefix = file.getOriginalFilename();
        String newCoursewareAbsoluteName = pdfPath + prefix;
        String newCoursewareRelativeName = "/static/pdf/" + prefix;
        Courseware dbCourseware = new Courseware();
        //查找在数据库里的PDF
        CoursewareExample coursewareExample = new CoursewareExample();
        coursewareExample.createCriteria().andContentTypeEqualTo(contentTypeId).andCourseIdEqualTo(courseId);
        List<Courseware> coursewares = coursewareMapper.selectByExample(coursewareExample);
        if (coursewares.size() != 0) {
            dbCourseware = coursewares.get(0);
            String dbPDFName = pdfUtil.getFileName(dbCourseware.getCoursewareLoc());
            pdfUtil.deletePdf(dbPDFName);
            dbCourseware.setCoursewareLoc(newCoursewareRelativeName);
            coursewareMapper.updateByPrimaryKey(dbCourseware);
        } else {
            dbCourseware.setContentType(contentTypeId);
            dbCourseware.setCourseId(courseId);
            dbCourseware.setCoursewareLoc(newCoursewareRelativeName);
            coursewareMapper.insert(dbCourseware);
        }
        File coursewareFile = new File(newCoursewareAbsoluteName);
        try {
            pdfUtil.uploadPdf(file, coursewareFile);
        } catch (IOException e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Course> findAllCourses() {
        return courseMapper.selectByExample(null);
    }

    @Override
    public List<ContentType> findAllContentTypeInTeachingResource() {
        ContentTypeExample contentTypeExample = new ContentTypeExample();
        List<String> typeNames = new ArrayList<>();
        typeNames.add("授课计划");
        typeNames.add("教学课件");
        contentTypeExample.createCriteria().andNameIn(typeNames);
        List<ContentType> contentTypes = contentTypeMapper.selectByExample(contentTypeExample);
        return contentTypes;
    }

    @Override
    public boolean deletePowerpoint(Integer coursewareIds) {
        Courseware courseware = coursewareMapper.selectByPrimaryKey(coursewareIds);
        int deleteSuccess = coursewareMapper.deleteByPrimaryKey(coursewareIds);
        String fileName = powerPointUtil.getFileName(courseware.getCoursewareLoc());
        powerPointUtil.deletePhoto(fileName);
        if (deleteSuccess == 0) {
            return false;
        }
        return true;
    }
}
