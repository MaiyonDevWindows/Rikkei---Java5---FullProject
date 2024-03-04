package com.maiyon.controller.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminPageController {
    @RequestMapping
    public String adminDashboard(){
        return "/admin/Home/index";
    }
    @GetMapping("/page/faq")
    public String faqPage(){
        return "/admin/Page/page-faq";
    }
    @GetMapping("/page/term")
    public String termPage(){
        return "/admin/Page/page-terms";
    }
    @GetMapping("/page/help")
    public String helpCenterPage(){
        return "/admin/Page/page-help-center";
    }
    @GetMapping("/page/404")
    public String notFoundPage(){
        return "/admin/Page/page-404";
    }
}
