package com.tata.eCommerce.service;

import com.tata.eCommerce.model.Category;
import com.tata.eCommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

//    List<Category> categories = new ArrayList<>();
//    Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        categoryRepository.delete(category);
        return "category with categoryID: "+ categoryId + " removed successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    @Override
    public void addCategory(Category category) {
//        category.setCategoryId(nextId++);
        categoryRepository.save(category);
//        categories.add(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
//        return categories;
    }
}
