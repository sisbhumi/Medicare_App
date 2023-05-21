package com.example.medicareapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.medicareapp.entity.Orders;
import com.example.medicareapp.service.OrderService;

@Controller
@CrossOrigin("http://localhost:3000")
public class orderController {
	
	@Autowired
	private OrderService orderService;
	
	
//	@GetMapping("/order/{id}")
//	public ResponseEntity<?> getProductName(@PathVariable Long Id){
//		Optional<Orders> order = this.orderService.findProductById(Id);
//	    return ResponseEntity.ok(order);
//	}
	
	@PostMapping("/user/order")
	public ResponseEntity<?> setOrder(@RequestBody Orders order){
		
		Orders saveOrder = this.orderService.addOrder(order);
	    return ResponseEntity.ok(saveOrder);
	}
}
