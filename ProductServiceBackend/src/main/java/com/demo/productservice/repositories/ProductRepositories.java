package com.demo.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.productservice.models.Product;

@Repository
public interface ProductRepositories extends JpaRepository<Product, UUID>{

	
}
