package com.turing.professional_website.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jack
 * @date 2019-06-26-22:28
 */
@Controller
public class PageController {

    @ResponseBody
    @RequestMapping("/pageLogin")
    public String pageLogin(){
        return "你倒是登陆啊小伙子...";
    }

    @RequestMapping("/pageSwagger")
    public String pageSwagger2(){
        System.out.println("...");
        return "swagger-ui";
    }

}
