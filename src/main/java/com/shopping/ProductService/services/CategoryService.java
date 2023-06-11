package com.shopping.ProductService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.ProductService.model.Category;
import com.shopping.ProductService.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> fetchAllCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Category> fetchById(Long id) {
		return categoryRepository.findById(id);
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
}
