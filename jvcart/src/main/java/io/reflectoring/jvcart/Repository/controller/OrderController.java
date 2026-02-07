package io.reflectoring.jvcart.Repository.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.jvcart.Dto.CreateOrderRequest;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	public ResponEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest){
		
		
		
	}

}
