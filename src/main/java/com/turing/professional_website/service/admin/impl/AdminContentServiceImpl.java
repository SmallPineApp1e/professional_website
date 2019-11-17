package com.turing.professional_website.service.admin.impl;

import com.turing.professional_website.dao.ContentMapper;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.entity.ContentExample;
import com.turing.professional_website.service.admin.AdminContentService;
import com.turing.professional_website.util.ImageUtil;
import com.turing.professional_website.util.PdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Meng
 * @date 2019/11/16
 */
@Service
@Transactional
public class AdminContentServiceImpl implements AdminContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Value("${pdfPath}")
    private String pdfDir;
    @Value("${teacher.ImgPath}")
    String imgDir;
    @Autowired
    private PdfUtil pdfUtil;
    @Autowired
    private ImageUtil imageUtil;

    @Override
    public boolean updateDataById(Integer contentTypeId, String contentTitle, MultipartFile data) {
        Content content = null;
        if (pdfUtil.isPdf(data)) {
            ContentExample contentExample = new ContentExample();
            contentExample.createCriteria().andContentTypeEqualTo(contentTypeId);
            List<Content> contents = contentMapper.selectByExample(contentExample);
            if (!contents.isEmpty()) {
                content = contents.get(0);
                String prefix = pdfUtil.getUUIDName();
                String fileName = prefix + ".pdf";
                String fileRealPath = pdfDir + fileName;
                File uploadFile = new File(fileRealPath);
                try {
                    pdfUtil.deletePdf(pdfUtil.getFileName(content.getContent()));
                    pdfUtil.uploadPdf(data, uploadFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                content.setContent("/static/pdf/" + fileName);
                content.setContentTitle(contentTitle);
                contentMapper.updateByExample(content, contentExample);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Content findContentByContentTypeId(Integer contentTypeId) {
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andContentTypeEqualTo(contentTypeId);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        return contents.isEmpty() ? null : contents.get(0);
    }

    @Override
    public boolean updateContentsById(Integer contentTypeId, String contentTitle, MultipartFile[] datas) {
        if (!imageUtil.isPhoto(datas)) {
            return false;
        }
        if (datas.length != 5) {
            return false;
        }
        ContentExample contentExample = new ContentExample();
        contentExample.createCriteria().andContentTypeEqualTo(contentTypeId);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        int i = 0;
        System.out.println(contents.size());
        for (Content content : contents) {
            String suffix = imageUtil.getSuffix(datas[i]);
            String prefix = imageUtil.getUUIDName();
            String fileName = prefix + suffix;
            String fileRealPath = imgDir + fileName;
            File uploadFile = new File(fileRealPath);
            try {
                System.out.println(imgDir + imageUtil.getFileName(content.getContent()));
                imageUtil.deletePhoto(imageUtil.getFileName(content.getContent()));
                imageUtil.uploadPhoto(datas[i], uploadFile);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            contentMapper.deleteByPrimaryKey(content.getId());
            Content newContent = new Content();
            newContent.setContentType(contentTypeId);
            newContent.setContent("/static/icon/" + fileName);
            newContent.setContentTitle(contentTitle);
            newContent.setIsFile(true);
            contentMapper.insertSelective(newContent);
            System.out.println(newContent.getId());
            i++;
        }
        return true;
    }

    @Override
    public List<Content> findContentsByContentTypeId(Integer contentTypeId) {
        ContentExample contentExample = new ContentExample();
        contentExample.createCriteria().andContentTypeEqualTo(contentTypeId);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        return contents;
    }

    @Override
    public Content findContentById(Integer id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveContent(Content content) {
        content.setIsFile(false);
        contentMapper.insertSelective(content);
    }

    @Override
    public void deleteContentById(Integer id) {
        contentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateContentById(Content content) {
        contentMapper.updateByPrimaryKeySelective(content);
    }
}
