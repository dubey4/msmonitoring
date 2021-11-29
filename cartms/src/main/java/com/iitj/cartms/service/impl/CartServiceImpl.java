package com.iitj.cartms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iitj.cartms.assembler.CartAssembler;
import com.iitj.cartms.entity.CartEntity;
import com.iitj.cartms.model.Cart;
import com.iitj.cartms.model.Product;
import com.iitj.cartms.respository.CartRepository;
import com.iitj.cartms.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartAssembler cartAssembler;

	@Autowired
	RestTemplate rt;

	@Transactional
	@Override
	public Cart addItem(Cart cart) {
		LOGGER.info("Entry");
		CartEntity cartEntity = cartAssembler.convertDTOToEntity(cart);
		cartRepository.save(cartEntity);
		cart.setId(cartEntity.getId());
		LOGGER.info("Exit");
		return cart;
	}

	@Transactional
	@Override
	public Cart deleteItem(Cart cart) {
		LOGGER.info("Entry");
		cartRepository.deleteByProductIdAndUserId(cart.getProductId(), cart.getUserId());
		LOGGER.info("Exit");
		return cart;
	}

	@Transactional
	@Override
	public List<Product> getItems(long userId) {
		LOGGER.info("Entry");
		List<Product> products = new ArrayList<>();
		cartRepository.getByUserId(userId).stream().forEach(cartEnity -> {
			products.add(rt.getForObject("http://localhost:8081/products/" + cartEnity.getProductId(), Product.class));
		}

		);

		LOGGER.info("Exit");
		return products;
	}

}
