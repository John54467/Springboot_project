package io.reflectoring.jvcart.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductReviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Double rating;
	private String comment;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public ProductReviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public ProductReviews(Long id, Double rating, String comment) {
		super();
		Id = id;
		this.rating = rating;
		this.comment = comment;
	}
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private product product; 

    // ... (Keep existing constructors and other getters/setters) ...

   
    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }
}
