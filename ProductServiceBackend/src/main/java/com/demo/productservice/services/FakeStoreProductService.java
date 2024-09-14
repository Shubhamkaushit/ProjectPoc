package com.demo.productservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.demo.productservice.customexceptions.ProductNotFoundException;
import com.demo.productservice.dtos.FakeStoreProductDto;
import com.demo.productservice.dtos.GenericProductDto;
import com.demo.productservice.thirdpartyclient.FakeStoreClient;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

	private FakeStoreClient fakeStoreAdapter;
	
	public FakeStoreProductService(FakeStoreClient fakeStoreAdapter) {
		// TODO Auto-generated constructor stub
		
		this.fakeStoreAdapter = fakeStoreAdapter;
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub

		List<GenericProductDto> genericProductDtos = new ArrayList<GenericProductDto>();
		List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
		
		for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
			genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
		}
		
		return genericProductDtos;
	}

	private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {

		GenericProductDto genericProductDto = new GenericProductDto();
		genericProductDto.setId(fakeStoreProductDto.getId());
		genericProductDto.setTitle(fakeStoreProductDto.getTitle());
		genericProductDto.setPrice(fakeStoreProductDto.getPrice());
		genericProductDto.setDescription(fakeStoreProductDto.getDescription());
		genericProductDto.setCategory(fakeStoreProductDto.getCategory());
		genericProductDto.setImage(fakeStoreProductDto.getImage());

		return genericProductDto;
	}

	@Override
	public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		// Integrate the FakeStore API
		// RestTemplate

		return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
	}

	@Override
	public GenericProductDto deleteProduct(Long id) {
		// TODO Auto-generated method stub

		return convertToGenericProductDto(fakeStoreAdapter.deleteProduct(id));
	}

	@Override
	public GenericProductDto createProduct(GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub

		return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		/// Dummy commit

	}

}
