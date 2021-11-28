package com.iitj.orderms.service;

import com.iitj.orderms.model.Cart;
import com.iitj.orderms.model.Order;

public interface OrderService {
	
	public Order palceOrder(Cart cart);

}
