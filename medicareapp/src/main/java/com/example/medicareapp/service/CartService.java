package com.example.medicareapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicareapp.entity.Cart;
import com.example.medicareapp.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepo;
	
	public Cart addItem(Cart cart) {
		return this.cartRepo.save(cart);
	}
	public Iterable<Cart> findAllProucts() {
		// TODO Auto-generated method stub
		return this.cartRepo.findAll();
	}
	
	
}
