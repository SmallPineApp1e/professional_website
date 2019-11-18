package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.ContentMapper;
import com.turing.professional_website.entity.Content;
import com.turing.professional_website.entity.ContentExample;
import com.turing.professional_website.service.guest.ProfessionalBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-9:59
 */
@Service
public class ProfessionalBuildingServiceImpl implements ProfessionalBuildingService {

    @Autowired
    ContentMapper contentMapper;

    @Override
    public List<Content> getProfessionalBuildingByContentTypeId(Integer contentTypeId) {
        ContentExample contentExample = new ContentExample();
        contentExample.createCriteria().andContentTypeEqualTo(contentTypeId);
        List<Content> contents = contentMapper.selectByExample(contentExample);
        return contents;
    }
}
