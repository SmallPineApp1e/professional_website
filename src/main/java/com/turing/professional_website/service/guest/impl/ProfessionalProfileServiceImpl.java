package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.ContentMapper;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.entity.ContentExample;
import com.turing.professional_website.service.guest.ProfessionalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-0:12
 */
@Service
public class ProfessionalProfileServiceImpl implements ProfessionalProfileService {

    @Autowired
    ContentMapper contentMapper;

    @Override
    public List<Content> findAllContents() {
        ContentExample contentExample = new ContentExample();
        contentExample.createCriteria().andContentTypeEqualTo(1);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        return contents;
    }
}
