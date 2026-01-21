package io.reflectoring.jvcart.ProductReviewdto;



public class ProductReviewDto {
	private Long productid;
	private String comment;
	private Double rating;
	
	public Long getProductId() {
		return productid;
	}
	public void setProductId(Long productId) {
		this.productid = productId;
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
