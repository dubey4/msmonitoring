package com.iitj.orderms.assembler;

import org.springframework.stereotype.Component;

import com.iitj.orderms.entity.OrderEntity;
import com.iitj.orderms.model.Order;

@Component
public class OrderAssembler {
	
	public Order convertEntityToDto(OrderEntity oderEntity) {
		Order order=new Order();
		order.setOrderId(oderEntity.getOrderId());
		order.setStatus("Success");
		return order;
	}

}
