package io.reflectoring.jvcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer quantity;
	private String image;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private product products;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public product getProducts() {
		return products;
	}
	public void setProducts(product products) {
		this.products = products;
	}
	// Add public no-arg constructor for JPA and to allow new OrderItem()
	public OrderItem() {
		super();
	}
	public OrderItem(String name, Integer quantity, String image, Double price, product products) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.image = image;
		this.price = price;
		this.products = products;
	}

}