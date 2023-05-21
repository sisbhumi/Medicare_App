package com.example.medicareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.medicareapp.entity.Cart;
import com.example.medicareapp.entity.Product;
import com.example.medicareapp.repository.CartRepository;
import com.example.medicareapp.service.CartService;
import com.example.medicareapp.service.ProductService;

@Controller
@CrossOrigin("http://localhost:3000")
public class cartController {
	
	@Autowired
	public CartService carService;
	
	@Autowired
	public ProductService prodSerice;
	
	@Autowired
	public CartRepository cartRepo;
	
	@PostMapping("/cart/{id}")
	public ResponseEntity<Cart> addProducttoCart(@PathVariable Long id ) {
		Product product = this.prodSerice.findProduct(id);
		String name  = product.getName();
		Double price = product.getPrice();
		Cart cart = new Cart();
				
		cart.setName(name);
		cart.setPrice(price);
		this.cartRepo.save(cart);
		 
		return ResponseEntity.ok(cart);
		
	}
	
	@GetMapping("/cart")
	public ResponseEntity<?> getProductfromCart() {
		 Iterable<Cart> cart= this.carService.findAllProucts();
		    return ResponseEntity.ok(cart);
		
	}
	
	@DeleteMapping("/cart/remove/{id}")
	public ResponseEntity<?> removeProductfromCart(@PathVariable Long id ) {
		 this.cartRepo.deleteById(id);
		    return ResponseEntity.status(HttpStatus.OK).build();
		
	} 
	
}
