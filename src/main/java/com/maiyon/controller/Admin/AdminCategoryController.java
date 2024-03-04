package com.maiyon.controller.Admin;

import com.maiyon.model.entity.Category;
import com.maiyon.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    private final CategoryService categoryService;
    // * Get all categories by pages.
    @GetMapping
    public String getAllCategories(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "/admin/Category/app-categories-list";
    }
    // * Create a new category.
    @GetMapping("/create")
    public String createCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/Category/app-category-create";
    }
    @GetMapping("/detail/{id}")
    // * Get category by id.
    public String getCategory(Model model, @PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        category.ifPresent(value -> model.addAttribute("category", value));
        return "/admin/Category/app-category-detail";
    }
    @GetMapping("/update/{id}")
    public String getUpdate(Model model, @PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        category.ifPresent(value -> model.addAttribute("category", value));
        return "/admin/Category/app-category-update";
    }
    @PostMapping("/update")
    public String postUpdate(@ModelAttribute("category") Category categoryRequest) {
        Optional<Category> checkCategory = categoryService.findById(categoryRequest.getCategoryId());
        if(checkCategory.isPresent()){
            Category updateCategory = checkCategory.get();
            if(categoryRequest.getCreatedDate() == null)
                categoryRequest.setCreatedDate(updateCategory.getCreatedDate());
        }
        categoryService.save(categoryRequest);
        return "redirect:/admin/categories";
    }
    @GetMapping("/delete/{categoryId}")
    public String deleteCategoryById(@PathVariable("categoryId") Long categoryId){
        categoryService.delete(categoryId);
        return "redirect:/admin/categories";
    }
}