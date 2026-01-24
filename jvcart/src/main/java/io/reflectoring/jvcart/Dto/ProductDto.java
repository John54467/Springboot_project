package io.reflectoring.jvcart.Dto;
import java.util.List;

import io.reflectoring.jvcart.entity.ProductReviews;
//import io.reflectoring.jvcart.entity.productimage;




public class ProductDto {

	private Long id;

	private String name;
	

	private Double price;
	

	private String description;
	
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	private Double rating = 0.0;
	

	private String seller;
	

	private Integer stock;

	private Integer numsofReviews=0;
	

	//private List<productimage> images;
	
	
	private List<ProductReviewDto> Reviews;
	
	public List<ProductReviews> getReviews() {
		return Reviews;
	}
	public void setReviews(List<ProductReviewDto> Reviews) {
		this.Reviews = Reviews;
	}
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