package com.shopping.ProductService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.shopping.ProductService.model.Category;
import com.shopping.ProductService.model.Product;
import com.shopping.ProductService.services.CategoryService;
import com.shopping.ProductService.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
@Autowired
    private final ProductService productService;
    
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

//	@Autowired
//	 private CategoryService categoryService;
//	
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
  
		Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> fetchAllProducts() {
        List<Product> products = productService.fetchAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> fetchProductById(@PathVariable Long id) {
        Optional<Product> product = productService.fetchProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/category/{category_id}")
//    public ResponseEntity<List<Product>> fetchByProductCategory(@PathVariable Long category_id) {
//        Optional<Category> category = categoryService.fetchById(category_id);
//        if (category.isPresent()) {
//            List<Product> products = productService.fetchByProductCategory(category.get());
//            return ResponseEntity.ok(products);
//        }
//        return ResponseEntity.notFound().build();
//    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> fetchByProductName(@PathVariable String name) {
        List<Product> products = productService.fetchByProductName(name);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}/increase-stock")
    public ResponseEntity<Product> increaseStock(@PathVariable Long id, @RequestParam int quantity) {
        Product product = productService.increaseStock(id, quantity);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/reduce-stock")
    public ResponseEntity<Product> reduceStock(@PathVariable Long id, @RequestParam int quantity) {
        Product product = productService.reduceStock(id, quantity);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/update-stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestParam int newStock) {
        Product product = productService.updateStock(id, newStock);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }
}
