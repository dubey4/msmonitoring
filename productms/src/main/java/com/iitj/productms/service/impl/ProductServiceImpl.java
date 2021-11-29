package com.iitj.productms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitj.productms.assembler.ProductAssembler;
import com.iitj.productms.controller.ProductController;
import com.iitj.productms.entity.ProductEntity;
import com.iitj.productms.model.Product;
import com.iitj.productms.repository.ProductRepository;
import com.iitj.productms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductAssembler productAssembler;

	@Override
	public List<Product> getProducts() {
		LOGGER.info("Entry");
		List<Product> pl=new ArrayList<>();
		productRepository.findAll().forEach(p->pl.add(productAssembler.convertEntityToDTO(p)));
		LOGGER.info("Exit");
		return pl;
	}

	@Override
	public Product updateQunatity(Product product) {
		LOGGER.info("Entry");
		productRepository.save(productAssembler.convertDTOToEntity(product));
		LOGGER.info("Exit");
		return product;
	}

	@Override
	public Product getProductById(long id) {
		LOGGER.info("Entry");
		Optional<ProductEntity> findById = productRepository.findById(id);
		Product product=null;
		if(findById.isPresent()) {
			product=productAssembler.convertEntityToDTO(findById.get());
		}
		LOGGER.info("Exit");
		return product;
	}

}
