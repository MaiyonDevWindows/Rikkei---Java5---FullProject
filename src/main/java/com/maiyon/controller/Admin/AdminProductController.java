package com.maiyon.controller.Admin;

import com.maiyon.model.entity.Product;
import com.maiyon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {
    private final ProductService productService;
    // * Get all products by pages.
    @RequestMapping
    public String getAllProducts(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "/admin/Product/app-products-list";
    }
    // * Get product by id.
    @RequestMapping("/detail/{productId}")
    public String getProductById(Model model, @PathVariable("productId") Long productId){
        Optional<Product> product = productService.findById(productId);
        product.ifPresent(value -> model.addAttribute("product", product));
        return "/admin/Product/app-product-detail";
    }
    // * Create a new product.
    // * Update product.
    // * Delete product by id.
    @GetMapping("/delete/{productId}")
    public String deleteProductById(@PathVariable("productId") Long productId){
        productService.delete(productId);
        return "redirect:/admin/products";
    }
}