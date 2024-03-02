package com.maiyon.controller.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class UserHomeController {
    @RequestMapping
    public String userHome(){
        return "user/index";
    }
}