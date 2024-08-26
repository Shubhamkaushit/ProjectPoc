package com.demo.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{

	private String title;
	private int price;
	private Category category;
	private String desc;
	private String image;
}
