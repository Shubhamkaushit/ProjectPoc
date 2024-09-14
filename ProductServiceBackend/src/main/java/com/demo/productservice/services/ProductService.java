package com.demo.productservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.productservice.customexceptions.ProductNotFoundException;
import com.demo.productservice.dtos.GenericProductDto;

@Service
public interface ProductService {

	List<GenericProductDto> getAllProducts();

	GenericProductDto getProductById(Long id) throws ProductNotFoundException;

	GenericProductDto deleteProduct(Long id);

	public GenericProductDto createProduct(GenericProductDto genericProductDto);

	public void updateProduct();
}
