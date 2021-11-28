package com.iitj.orderms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iitj.orderms.entity.CartEntity;

@Repository
public interface CartRepository extends CrudRepository<CartEntity, Long> {

	public List<CartEntity> getByUserId(long userId);
	
	public List<CartEntity> deleteByProductIdAndUserId(long productId,long userId);
}
