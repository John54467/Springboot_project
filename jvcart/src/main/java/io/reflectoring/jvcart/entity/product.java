package io.reflectoring.jvcart.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="products")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	@NotBlank(message = "Name field is requried")
	private String name;
	
	@Column(nullable=false)
	@NotNull(message = "Price field is requried")
	@PositiveOrZero(message="value must be zero or greater than zero")
	private Double price;
	
	@NotBlank(message = "Description field is requried")
	private String description;
	
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@NotNull(message = "Description field is requried")
	private Double rating = 0.0;
	
	@NotBlank(message = "seller field is requried")
	private String seller;
	
	@NotNull(message = "Stock field is requried")
	private Integer stock;
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer numsofReviews=0;
	
	@OneToMany(cascade= CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="ProductId")
	private List<productimage> images;
	
	@OneToMany(cascade= CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="product_id")
	private List<ProductReviews> Reviews;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public product(Long id, String name, Double price, String description,String category,Double rating, String seller, Integer stock,
			Integer numsofReviews) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category=category;
		this.rating = rating;
		this.seller = seller;
		this.stock = stock;
		this.numsofReviews = numsofReviews;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getNumsofReviews() {
		return numsofReviews;
	}
	public void setNumsofReviews(Integer numsofReviews) {
		this.numsofReviews = numsofReviews;
	}
}