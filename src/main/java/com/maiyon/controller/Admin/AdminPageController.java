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
        return "/admin/Pages/app-admin";
    }
    @GetMapping("/page/faq")
    public String faqPage(){
        return "/admin/Pages/page-faq";
    }
    @GetMapping("/page/term")
    public String termPage(){
        return "/admin/Pages/page-terms";
    }
    @GetMapping("/page/help")
    public String helpCenterPage(){
        return "/admin/Pages/page-help-center";
    }
    @GetMapping("/page/404")
    public String notFoundPage(){
        return "/admin/Pages/page-404";
    }
}
