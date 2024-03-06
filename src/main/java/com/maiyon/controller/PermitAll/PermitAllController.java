package com.maiyon.controller.PermitAll;

import com.maiyon.model.entity.Category;
import com.maiyon.model.entity.Product;
import com.maiyon.service.CategoryService;
import com.maiyon.service.ProductService;
import com.maiyon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PermitAllController {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping("/shop")
    public String shopHome(Model model){
        List<Category> categories = categoryService.getAll();
        List<Product> products = productService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "user/Pages/app-shop";
    }
    @GetMapping("/register")
    public String register(){
        return "/user/Pages/app-register";
    }
    @GetMapping("/login")
    public String login(){
        return "/user/Pages/app-login";
    }
}
