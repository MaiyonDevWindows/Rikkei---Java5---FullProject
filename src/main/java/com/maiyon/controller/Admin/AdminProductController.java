package com.maiyon.controller.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {
    // * Get all products by pages.
    @RequestMapping
    public String getAllProducts(){
        return "/admin/Product/app-products-list";
    }
    // * Get product by id.
    @RequestMapping("/id")
    public String getProductById(){
        return "/admin/Product/app-product";
    }
}
