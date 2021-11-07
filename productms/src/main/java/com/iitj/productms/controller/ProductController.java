package com.iitj.productms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iitj.productms.model.Product;
import com.iitj.productms.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@PutMapping("/products")
	public Product updateQunatity(@RequestBody  Product product) {
		return productService.updateQunatity(product);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable  Long id) {
		return productService.getProductById(id);
	}

}
