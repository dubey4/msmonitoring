package com.iitj.orderms.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitj.orderms.assembler.OrderAssembler;
import com.iitj.orderms.entity.CartEntity;
import com.iitj.orderms.entity.OrderEntity;
import com.iitj.orderms.model.Cart;
import com.iitj.orderms.model.Order;
import com.iitj.orderms.repository.CartRepository;
import com.iitj.orderms.repository.OrderRepository;
import com.iitj.orderms.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderAssembler orderAssembler;
	

	@Override
	public Order palceOrder(Cart cart) {
		LOGGER.info("Entry");
		 List<CartEntity> cartEntities = cartRepository.getByUserId(cart.getUserId());
		 
		 cartEntities.forEach(ce->{
			 
			 ce.setStatus("C");
			 
		 });
		 
		 cartRepository.saveAll(cartEntities);
				 
		 OrderEntity order=new OrderEntity();
		 order.setOrderId(UUID.randomUUID().toString());
		 order.setUserId(cart.getUserId());
		 order.setStatus("S");
		 
		 orderRepository.save(order);
		 LOGGER.info("Exit");
		 return orderAssembler.convertEntityToDto(order);
	}

}
