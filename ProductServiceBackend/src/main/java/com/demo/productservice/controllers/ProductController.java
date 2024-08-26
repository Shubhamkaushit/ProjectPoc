package com.demo.productservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.productservice.dtos.FakeStoreProductDto;
import com.demo.productservice.dtos.GenericProductDto;
import com.demo.productservice.models.Product;
import com.demo.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	// Constructor Injection;
	ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {

		this.productService = productService;
	}

	// Setter Injection
	/*
	 * @Autowired public void setProductService(ProductService productService) {
	 * 
	 * this.productService = productService; }
	 */

	@GetMapping("/")
	public Product getAllProducts() {

		return null;
	}

	@GetMapping("/{id}")
	public GenericProductDto getProductById(@PathVariable("id") Long id) {

		// call the fake store product service
		//return "Scaler || Hello Product with id: " + id;
		
		return productService.getProductById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(Long id) {

	}

	@PostMapping
	public void createProduct() {

	}

	@PutMapping
	public void updateProduct() {

	}
}
