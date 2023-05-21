package com.example.medicareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicareapp.entity.Product;
import com.example.medicareapp.repository.ProductRepository;
import com.example.medicareapp.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@CrossOrigin("http://localhost:3000")
public class productController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		Iterable<Product> products = this.productService.findAllProducts();
		return ResponseEntity.ok(products);
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
	    Product product = this.productService.findProduct(id);
	    return ResponseEntity.ok(product);
	}
	
	@GetMapping("/product/name/{name}")
	public ResponseEntity<?> getProductByName(@PathVariable("name") String name) {
	    Iterable<Product> products = this.productService.findProductByName(name);
	    return ResponseEntity.ok(products);
	}
	
	
	@PostMapping("/add/product")
	public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
	    
	    Product saveProduct = this.productService.addProduct(product);
	    return ResponseEntity.ok(saveProduct);
	}	
	
	@PutMapping("/product/edit/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
	    
	    Product saveProduct = this.productService.updateProduct(product, id);
	    return ResponseEntity.ok(saveProduct);
	}
	
	
	@DeleteMapping("/products/del/{id}")
	public ResponseEntity<?> deleteProdById(@PathVariable Long id){
		this.repo.deleteById(id);
		 return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	
	
	
}