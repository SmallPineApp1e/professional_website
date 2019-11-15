package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.Content;
import com.turing.professional_website.service.guest.ProfessionalBuildingService;
import com.turing.professional_website.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-9:58
 */
@RestController
@RequestMapping("/guest")
public class ProfessionalBuildingController {

    @Autowired
    ProfessionalBuildingService professionalBuildingService;

    @GetMapping("/professionalBuilding")
    public Msg getProfessionalBuildingContentByContentTypeId(@RequestParam(name = "contentTypeId") Integer contentTypeId){
        List<Content> contents = professionalBuildingService.getProfessionalBuildingByContentTypeId(contentTypeId);
        return Msg.success().add("contents", contents);
    }

}
