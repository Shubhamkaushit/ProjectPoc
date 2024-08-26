package com.demo.productservice.services;

import org.springframework.stereotype.Service;

import com.demo.productservice.dtos.FakeStoreProductDto;
import com.demo.productservice.models.Product;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

	@Override
	public Product getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FakeStoreProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createProduct() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub

	}
}
