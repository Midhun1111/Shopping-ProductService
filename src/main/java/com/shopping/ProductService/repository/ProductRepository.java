package com.shopping.ProductService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.ProductService.model.Category;
import com.shopping.ProductService.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByProductname(String name);

//	List<Product> findByProduct_name(String name);

//	List<Product> findByProduct_category(Long category_id);


}
