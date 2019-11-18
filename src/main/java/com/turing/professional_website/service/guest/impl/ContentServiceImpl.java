package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.ContentMapper;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.entity.ContentExample;
import com.turing.professional_website.service.guest.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/11/14
 */
@Service
@Transactional
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public Content findContentByContentTypeId(Integer contentTypeId) {
        return contentMapper.selectByContentTypeId(contentTypeId);
    }

    @Override
    public List<Content> findContentsByContentTypeId(Integer contentTypeId) {
        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andContentTypeEqualTo(contentTypeId);
        return contentMapper.selectByExample(contentExample);
    }

    @Override
    public Content findContentById(Integer id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Content> findContentsById(Integer id) {
        ContentExample contentExample=new ContentExample();
        contentExample.setOrderByClause("upload_time DESC");
        ContentExample.Criteria criteria=contentExample.createCriteria();
        criteria.andContentTypeEqualTo(id);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        return contents;
    }
}
