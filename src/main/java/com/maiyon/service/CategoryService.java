package com.maiyon.service;

import com.maiyon.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    void delete(Long categoryId);
    Optional<Category> findById(Long categoryId);
}
