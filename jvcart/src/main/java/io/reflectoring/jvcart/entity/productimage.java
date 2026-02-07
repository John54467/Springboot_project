package io.reflectoring.jvcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class productimage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String publicId;
	private String url;
	public productimage() {
		super();
	}
	public productimage(Long id, String publicId, String url) {
		super();
		Id = id;
		this.publicId = publicId;
		this.url = url;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private product product; 
	 
	public productimage( String url, product product) {
		// Store the provided URL as-is. The application serves static files from the `uploads/` directory
		// (configured in application.properties). Seeded values use paths like "/Product/1.jfif" so
		// we should not prefix another "/uploads" segment here.
		this.url = url;
		this.publicId = url;
		this.product = product;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


}