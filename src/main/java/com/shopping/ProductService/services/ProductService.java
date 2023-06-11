package com.shopping.ProductService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shopping.ProductService.model.Product;
import com.shopping.ProductService.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> fetchProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product updateProduct(Long id, Product updatedProduct) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			Product existingProduct = productOptional.get();
			existingProduct.setProductname(updatedProduct.getProductname());
			existingProduct.setDescription(updatedProduct.getDescription());
			existingProduct.setPrice(updatedProduct.getPrice());
			existingProduct.setImageurl(updatedProduct.getImageurl());
			existingProduct.setProductstock(updatedProduct.getProductstock());
			return productRepository.save(existingProduct);
		}
		return null;
	}

	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

//	public List<Product> fetchByProductCategory(Category category) {
//		return productRepository.findByProduct_category(category.getId());
//	}

	public List<Product> fetchByProductName(String name) {
		return productRepository.findByProductname(name);
	}

	public Product increaseStock(Long id, int quantity) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			Product existingProduct = productOptional.get();
			existingProduct.setProductstock(existingProduct.getProductstock() + quantity);
			return productRepository.save(existingProduct);
		}
		return null;
	}

	public Product reduceStock(Long id, int quantity) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			Product existingProduct = productOptional.get();
			int newStock = existingProduct.getProductstock() - quantity;
			if (newStock >= 0) {
				existingProduct.setProductstock(newStock);
				return productRepository.save(existingProduct);
			}
		}
		return null;
	}

	public Product updateStock(Long id, int newStock) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			Product existingProduct = productOptional.get();
			existingProduct.setProductstock(newStock);
			return productRepository.save(existingProduct);
		}
		return null;
	}


}
