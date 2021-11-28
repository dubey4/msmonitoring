package com.iitj.productms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	private long id;
	private String productName;
	private String productImage;
	private String productDescription;
	private int productCount;
	private double productPrice;
	
	

}
