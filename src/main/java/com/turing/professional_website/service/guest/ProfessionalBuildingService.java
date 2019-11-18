package com.turing.professional_website.service.guest;

import com.turing.professional_website.entity.Content;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-9:59
 */
public interface ProfessionalBuildingService {

    List<Content> getProfessionalBuildingByContentTypeId(Integer contentTypeId);

}
