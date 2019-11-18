package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.Content;
import com.turing.professional_website.service.guest.ProfessionalProfileService;
import com.turing.professional_website.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jack
 * @date 2019-11-15-0:11
 */
@RestController
@RequestMapping(value = "/guest")
public class ProfessionalProfileController {

    @Autowired
    ProfessionalProfileService professionalProfileService;

    @GetMapping(value = "/professionalProfile")
    public Msg findAllProfessionalProfile(){

        List<Content> contents = professionalProfileService.findAllContents();
        return Msg.success().add("contents", contents);

    }

}
