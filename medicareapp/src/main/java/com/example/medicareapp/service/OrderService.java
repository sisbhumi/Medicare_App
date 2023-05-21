package com.example.medicareapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicareapp.entity.Orders;
import com.example.medicareapp.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository order_repo;
	
	public Optional<Orders> findProductById(Long id) {
		// TODO Auto-generated method stub
		return this.order_repo.findById(id) ;
	}

	public Orders addOrder(Orders saveOrder) {
		// TODO Auto-generated method stub
		return this.order_repo.save(saveOrder);
	}

}
