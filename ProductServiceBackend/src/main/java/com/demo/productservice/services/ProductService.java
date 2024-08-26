package com.demo.productservice.services;

import org.springframework.stereotype.Service;

import com.demo.productservice.dtos.GenericProductDto;
import com.demo.productservice.models.Product;

@Service
public interface ProductService {

	Product getAllProducts();

	GenericProductDto getProductById(Long id);

	void deleteProduct(Long id);

	public void createProduct();

	public void updateProduct();
}
