package com.demo.productservice.dtos;

import com.demo.productservice.models.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto extends BaseModel {

	private String title;
	private int price;
	private String category;
	private String description;
	private String image;
}
