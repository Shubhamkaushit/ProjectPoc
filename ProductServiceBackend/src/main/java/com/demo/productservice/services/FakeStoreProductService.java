package com.demo.productservice.services;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.productservice.dtos.FakeStoreProductDto;
import com.demo.productservice.dtos.GenericProductDto;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

	private RestTemplateBuilder restTemplateBuilder;

	private String getProductUrl = "https://fakestoreapi.com/products/{id}";
	
	private String getAllProductsUrl = "https://fakestoreapi.com/products";

	FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {

		this.restTemplateBuilder = restTemplateBuilder;
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		//ResponseEntity<List<FakeStoreProductDto>> responseEntity =
		restTemplate.getForEntity(getAllProductsUrl, FakeStoreProductDto.class);
		return null;
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
	public GenericProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		// Integrate the FakeStore API
		// RestTemplate

		RestTemplate restTemplate = restTemplateBuilder.build();
		
		ResponseEntity<FakeStoreProductDto> responseEntity = 
				restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class, id);
		
		/*
		 * FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
		 * System.out.println(fakeStoreProductDto.toString());
		 */
		
		return convertToGenericProductDto(responseEntity.getBody());
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
		/// Dummy commit
		

	}

}
