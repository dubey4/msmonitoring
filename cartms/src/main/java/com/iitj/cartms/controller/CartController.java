package com.iitj.cartms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iitj.cartms.model.Cart;
import com.iitj.cartms.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PutMapping("/cart/add/products")
	public Cart addItem(@RequestBody  Cart cart) {
		cartService.addItem(cart);
		return cart;
	}
	
	
	@DeleteMapping("/cart/delete/products")
	public Cart deleteItem(@RequestBody Cart cart) {
		cartService.deleteItem(cart);
		return cart;
	}
	
	@GetMapping("/cart/get/products/{userId}")
	public List<Cart> getItems(@PathVariable long userId) {
		return  cartService.getItems(userId);
	}

}
