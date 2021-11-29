package com.iitj.cartms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iitj.cartms.model.Cart;
import com.iitj.cartms.model.Product;
import com.iitj.cartms.service.CartService;

@RestController
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@Autowired
	RestTemplate restTemplate;

	@PutMapping("/cart/add/products")
	public Cart addItem(@RequestBody Cart cart) {
		LOGGER.info("Entry");
		cartService.addItem(cart);
		LOGGER.info("Exit");
		return cart;
	}

	@DeleteMapping("/cart/delete/products")
	public Cart deleteItem(@RequestBody Cart cart) {
		LOGGER.info("Entry");
		cartService.deleteItem(cart);
		LOGGER.info("Exit");
		return cart;
	}

	@GetMapping("/cart/get/products/{userId}")
	public List<Product> getItems(@PathVariable long userId) {
		return cartService.getItems(userId);
	}
	
	

}
