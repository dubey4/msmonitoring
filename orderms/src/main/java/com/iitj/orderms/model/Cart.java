package com.iitj.orderms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cart {
	private long id;
	
	private long userId;
	
	private long productId;
	
	private long quantity;
	
	private String status;
}
