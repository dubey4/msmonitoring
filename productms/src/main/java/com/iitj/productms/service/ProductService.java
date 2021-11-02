package com.iitj.productms.service;

import java.util.List;

import com.iitj.productms.model.Product;

public interface ProductService {
	public List<Product> getProducts();
	 Product updateQunatity(Product product);
	 Product getProductById(long id);
}
