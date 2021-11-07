package com.iitj.paymentms.repository;

import org.springframework.data.repository.CrudRepository;

import com.iitj.paymentms.entity.PaymentEntity;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {

}
