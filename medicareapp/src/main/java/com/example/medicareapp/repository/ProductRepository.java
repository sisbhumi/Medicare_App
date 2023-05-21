package com.example.medicareapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medicareapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

	Iterable<Product> findByName(String name);

	
}