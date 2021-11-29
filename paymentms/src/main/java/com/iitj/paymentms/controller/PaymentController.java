package com.iitj.paymentms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {
	
	
	@Autowired
	RestTemplate restTemplate;

}
