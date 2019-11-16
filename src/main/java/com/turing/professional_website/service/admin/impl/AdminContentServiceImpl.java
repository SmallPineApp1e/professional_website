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
    @Autowired
    private PdfUtil pdfUtil;
    @Override
    public boolean updateDataById(Integer contentTypeId,String contentTitle, MultipartFile data) {
        Content content=null;
        if(pdfUtil.isPdf(data)){
            ContentExample contentExample=new ContentExample();
            contentExample.createCriteria().andContentTypeEqualTo(contentTypeId);
            List<Content> contents = contentMapper.selectByExample(contentExample);
            if(!contents.isEmpty()){
                content=contents.get(0);
                String prefix=pdfUtil.getUUIDName();
                String fileName=prefix+".pdf";
                String fileRealPath=pdfDir+fileName;
                File uploadFile=new File(fileRealPath);
                try{
                    pdfUtil.deletePdf(pdfUtil.getFileName(content.getContent()));
                    pdfUtil.uploadPdf(data,uploadFile);
                }catch (Exception e){
                    e.printStackTrace();
                    return false;
                }
                content.setContent("/static/pdf/"+fileName);
                content.setContentTitle(contentTitle);
                contentMapper.updateByExample(content,contentExample);
                return true;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Content findContentByContentTypeId(Integer contentTypeId) {
        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andContentTypeEqualTo(contentTypeId);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        return contents.isEmpty()?null:contents.get(0);
    }
}
