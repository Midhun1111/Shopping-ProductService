package com.shopping.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.ProductService.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
