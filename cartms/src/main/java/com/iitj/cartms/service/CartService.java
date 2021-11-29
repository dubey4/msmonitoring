package com.iitj.cartms.service;

import java.util.List;

import com.iitj.cartms.model.Cart;
import com.iitj.cartms.model.Product;

public interface CartService {
	
	public Cart addItem(Cart cart);
	public Cart deleteItem(Cart cart);
	public List<Product> getItems(long userId);

}
