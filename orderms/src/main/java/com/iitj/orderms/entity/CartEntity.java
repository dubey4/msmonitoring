package com.iitj.orderms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="product_quantity")
	private long quantity;
	
	@Column(name="status")
	private String status;
}
