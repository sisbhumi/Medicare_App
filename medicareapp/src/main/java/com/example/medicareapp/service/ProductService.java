package com.example.medicareapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicareapp.entity.Product;
import com.example.medicareapp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prod_repo;

	//Add Product
	public Product addProduct(Product p) {
		return this.prod_repo.save(p);
	}


	public Product findProduct(Long id) {
		// TODO Auto-generated method stub
		return this.prod_repo.findById(id).get();
	}


	public Iterable<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return this.prod_repo.findAll();
	}


	public Iterable<Product> findProductByName(String name) {
		// TODO Auto-generated method stub
		return this.prod_repo.findByName(name);
	}


	public Product updateProduct(Product newproduct, Long id) {
		this.prod_repo.findById(id)
		.map(product ->{
			product.setName(newproduct.getName());
			product.setPrice(newproduct.getPrice());
			product.setCategory(newproduct.getCategory());
			product.setQuantity(newproduct.getQuantity());
			product.setAvailable(newproduct.isAvailable());
			product.setDescription(newproduct.getDescription());
			return prod_repo.save(product);
			
		});
		// TODO Auto-generated method stub
		return newproduct;
	}

}