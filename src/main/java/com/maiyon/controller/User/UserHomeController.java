package com.maiyon.controller.User;

import com.maiyon.model.entity.Category;
import com.maiyon.model.entity.Product;
import com.maiyon.service.CategoryService;
import com.maiyon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserHomeController {
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping("/home")
    public String userHome(Model model){
        List<Category> categories = categoryService.getAll();
        List<Product> products = productService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "user/index";
    }
}