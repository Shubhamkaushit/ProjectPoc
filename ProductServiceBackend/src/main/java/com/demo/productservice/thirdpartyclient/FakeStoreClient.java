package com.demo.productservice.thirdpartyclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.demo.productservice.customexceptions.ProductNotFoundException;
import com.demo.productservice.dtos.FakeStoreProductDto;
import com.demo.productservice.dtos.GenericProductDto;

@Component
public class FakeStoreClient {



	private RestTemplateBuilder restTemplateBuilder;

	private String getProductUrl = "https://fakestoreapi.com/products/{id}";

	private String genericProductsUrl = "https://fakestoreapi.com/products";

	FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {

		this.restTemplateBuilder = restTemplateBuilder;
	}

	public List<FakeStoreProductDto> getAllProducts() {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = restTemplateBuilder.build();
		
		ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductsUrl,
				FakeStoreProductDto[].class);

		return List.of(responseEntity.getBody());

	}

	public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		// Integrate the FakeStore API
		// RestTemplate

		RestTemplate restTemplate = restTemplateBuilder.build();

		ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductUrl,
				FakeStoreProductDto.class, id);

		/*
		 * FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
		 * System.out.println(fakeStoreProductDto.toString());
		 */
		
		FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
		
		if(fakeStoreProductDto == null) {
			// Throw an Exception
			
			throw new ProductNotFoundException("Product with id: "+id+" not found");
		}

		return fakeStoreProductDto;
	}

	public FakeStoreProductDto deleteProduct(Long id) {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = restTemplateBuilder.build();
		
		RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
		
		ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = 
				restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
		
		ResponseEntity<FakeStoreProductDto> responseEntity = 
				restTemplate.execute(getProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
		
		return responseEntity.getBody();
	}

	public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> responseEntity = 
				restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);
		
		return responseEntity.getBody();
	}

	public void updateProduct() {
		// TODO Auto-generated method stub
		/// Dummy commit

	}


}
