package com.iitj.productms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product_inventory")
@Data
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_image")
	private String productImage;
	@Column(name="product_description")
	private String productDescription;
	@Column(name="product_count")
	private int productCount;

}
