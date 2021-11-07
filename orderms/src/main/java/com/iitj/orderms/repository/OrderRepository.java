package com.iitj.orderms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iitj.orderms.entity.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
