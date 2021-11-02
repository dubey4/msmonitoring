package com.iitj.productms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitj.productms.assembler.ProductAssembler;
import com.iitj.productms.entity.ProductEntity;
import com.iitj.productms.model.Product;
import com.iitj.productms.repository.ProductRepository;
import com.iitj.productms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductAssembler productAssembler;

	@Override
	public List<Product> getProducts() {
		List<Product> pl=new ArrayList<>();
		productRepository.findAll().forEach(p->pl.add(productAssembler.convertEntityToDTO(p)));
		return pl;
	}

	@Override
	public Product updateQunatity(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(productAssembler.convertDTOToEntity(product));
		return product;
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> findById = productRepository.findById(id);
		Product product=null;
		if(findById.isPresent()) {
			product=productAssembler.convertEntityToDTO(findById.get());
		}
		return product;
	}

}
