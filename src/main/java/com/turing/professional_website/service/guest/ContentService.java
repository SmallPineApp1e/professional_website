package com.turing.professional_website.service.guest;

import com.turing.professional_website.entity.Content;

import java.util.List;

/**
 * @author Meng
 * @date 2019/11/14
 */
public interface ContentService {
    Content findContentByContentTypeId(Integer contentTypeId);

    List<Content> findContentsByContentTypeId(Integer contentTypeId);
}
