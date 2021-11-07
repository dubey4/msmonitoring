package com.iitj.cartms.assembler;

import org.springframework.stereotype.Component;

import com.iitj.cartms.entity.CartEntity;
import com.iitj.cartms.model.Cart;

@Component
public class CartAssembler {
	
	public  Cart convertEntityToDTO(CartEntity cartEntity) {
		Cart cart=new Cart();
		cart.setId(cartEntity.getId());
		cart.setProductId(cartEntity.getProductId());
		cart.setQuantity(cartEntity.getQuantity());
		cart.setStatus(cartEntity.getStatus());
		cart.setUserId(cartEntity.getUserId());
		return cart;
	}
	
	public  CartEntity convertDTOToEntity(Cart cart) {
		CartEntity cartEntity=new CartEntity();
		cartEntity.setProductId(cart.getProductId());
		cartEntity.setQuantity(cart.getQuantity());
		cartEntity.setUserId(cart.getUserId());
		cartEntity.setStatus("P");
		return cartEntity;
	}

}
