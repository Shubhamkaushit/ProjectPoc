package com.demo.productservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.productservice.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{

}
