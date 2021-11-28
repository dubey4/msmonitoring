package com.iitj.cartms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitj.cartms.assembler.CartAssembler;
import com.iitj.cartms.entity.CartEntity;
import com.iitj.cartms.model.Cart;
import com.iitj.cartms.respository.CartRepository;
import com.iitj.cartms.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartAssembler cartAssembler;

	@Transactional
	@Override
	public Cart addItem(Cart cart) {
		// TODO Auto-generated method stub
		CartEntity cartEntity = cartAssembler.convertDTOToEntity(cart);
		cartRepository.save(cartEntity);
		cart.setId(cartEntity.getId());
		return cart;
	}

	@Transactional
	@Override
	public Cart deleteItem(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.deleteByProductIdAndUserId(cart.getProductId(),cart.getUserId());
		return cart;
	}

	@Transactional
	@Override
	public List<Cart> getItems(long userId) {
		// TODO Auto-generated method stub
		List<Cart> carts=new ArrayList<>();
		cartRepository.getByUserId(userId).stream().forEach(cartEnity->carts.add(cartAssembler.convertEntityToDTO(cartEnity)));
		return carts;
	}

}
