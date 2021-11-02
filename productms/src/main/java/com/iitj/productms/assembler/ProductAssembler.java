package com.iitj.productms.assembler;

import org.springframework.stereotype.Component;

import com.iitj.productms.entity.ProductEntity;
import com.iitj.productms.model.Product;

@Component
public class ProductAssembler {
	
	
	public  Product convertEntityToDTO(ProductEntity productEntity) {
		Product product=new Product();
		
		product.setId(productEntity.getId());
		product.setProductName(productEntity.getProductName());
		product.setProductDescription(productEntity.getProductDescription());
		product.setProductImage(productEntity.getProductImage());
		product.setProductCount(productEntity.getProductCount());
		return product;
	}
	
	public  ProductEntity convertDTOToEntity(Product product) {
		ProductEntity productEntity=new ProductEntity();
		
		productEntity.setId(product.getId());
		productEntity.setProductName(product.getProductName());
		productEntity.setProductDescription(product.getProductDescription());
		productEntity.setProductImage(product.getProductImage());
		productEntity.setProductCount(product.getProductCount());
		return productEntity;
	}

}
