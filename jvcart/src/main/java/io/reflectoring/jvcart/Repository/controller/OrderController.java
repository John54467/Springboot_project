package io.reflectoring.jvcart.Repository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.jvcart.Dto.CreateOrderRequest;
import io.reflectoring.jvcart.Service.OrderService;
import io.reflectoring.jvcart.entity.Order;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest){
		Order order = orderService.createOrder(orderRequest);
		return ResponseEntity.ok(order);
		
		
		
		
		
	}

}
