package com.iitj.orderms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iitj.orderms.model.Cart;
import com.iitj.orderms.model.Order;
import com.iitj.orderms.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/orders")
	public Order palceOrder(@RequestBody  Cart cart) {
		return orderService.palceOrder(cart);
	}
}
