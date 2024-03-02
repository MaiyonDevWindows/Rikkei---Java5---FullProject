package com.maiyon.controller.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminHomeController {
    @RequestMapping
    public String adminDashboard(){
        return "/admin/Home/index";
    }
}
