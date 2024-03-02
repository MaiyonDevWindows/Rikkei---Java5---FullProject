package com.maiyon.controller.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    // * Get all categories by pages.
    @RequestMapping
    public String getAllCategories(){
        return "/admin/Category/app-categories-list";
    }
    // * Get category by id.
    @RequestMapping("/id")
    public String getCategoryById(){
        return "/admin/Category/app-category";
    }
}
