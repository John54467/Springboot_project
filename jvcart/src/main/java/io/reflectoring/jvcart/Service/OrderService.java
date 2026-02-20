package io.reflectoring.jvcart.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reflectoring.jvcart.Dto.CreateOrderRequest;
import io.reflectoring.jvcart.Dto.OrderCreater;
import io.reflectoring.jvcart.Dto.OrderItemDto;
import io.reflectoring.jvcart.Repository.OrderRepository;
import io.reflectoring.jvcart.Repository.ProductRepository;
import io.reflectoring.jvcart.entity.Order;
import io.reflectoring.jvcart.entity.OrderItem;
import io.reflectoring.jvcart.entity.product;

@Service
public class OrderService {
	@Autowired
	private ProductRepository ProdRepo;	
	
	@Autowired
	private OrderRepository orderRepo;
	public OrderCreater createOrder(CreateOrderRequest orderRequest) {
		Order order = new Order();
		order.setStatus("PENDING");
		double TotalItemAmount = 0;
		for(OrderItemDto item : orderRequest.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setName(item.getName());
			orderItem.setPrice(item.getPrice());
			orderItem.setImage(item.getImage());
			orderItem.setQuantity(item.getQuantity());
			product product = ProdRepo.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
			orderItem.setProducts(product);
			order.getOrderItems().add(orderItem);
			
		}
		order.setTotalAmount(TotalItemAmount);
		double totalAmount = 0;
		double taxAmount = 10;
		totalAmount = TotalItemAmount + taxAmount;
		order.setTotalAmount(totalAmount);
		order.setTaxAmount(taxAmount);
		String refId = UUID.randomUUID().toString();
		order.setReferenceId(refId);
		orderRepo.save(order);
		return new OrderCreater(refId);
		
		
	}
	
	public Order getOrder(String referenceId) {
			// TODO Auto-generated method stub
		return orderRepo.findByReferenceId(referenceId).orElseThrow(() -> new RuntimeException("No order found with Ref Id"));
	}
	
	

}
