package com.maiyon.service;
import com.maiyon.model.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Product save(Product product);
    void delete(Long productId);
    Optional<Product> findById(Long productId);
}
