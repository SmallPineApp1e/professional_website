package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.ContentMapper;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.service.guest.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
