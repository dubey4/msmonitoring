package com.iitj.cartms.service;

import java.util.List;

import com.iitj.cartms.model.Cart;

public interface CartService {
	
	public Cart addItem(Cart cart);
	public Cart deleteItem(Cart cart);
	public List<Cart> getItems(long userId);

}
