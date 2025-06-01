package com.tata.eCommerce.service;

import com.tata.eCommerce.model.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);
    List<Category> getAllCategories();
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
}
