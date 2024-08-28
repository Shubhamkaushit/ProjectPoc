package com.demo.productservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.productservice.dtos.GenericProductDto;
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

	@GetMapping("")
	public List<GenericProductDto> getAllProducts() {

		return productService.getAllProducts();
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

	@PostMapping("")
	public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {

		return productService.createProduct(genericProductDto);
	}

	@PutMapping
	public void updateProduct() {

	}
}
