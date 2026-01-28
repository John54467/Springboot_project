package io.reflectoring.jvcart.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductReviewDto {
	@NotNull(message="prouctId Id is required")
	private Long productId;
	@NotBlank(message="comment cannot be blank")
	private String comment;
	@NotNull(message="rating is requried")
	private Double rating;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}

}