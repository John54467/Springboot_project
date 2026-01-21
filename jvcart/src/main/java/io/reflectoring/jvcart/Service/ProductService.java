package io.reflectoring.jvcart.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.reflectoring.jvcart.ProductReviewdto.ProductReviewDto;
import io.reflectoring.jvcart.ProductSpecification.ProductSpecification;
import io.reflectoring.jvcart.Repository.ProductRepository;
import io.reflectoring.jvcart.Repository.ProductReviewRepository;
import io.reflectoring.jvcart.entity.ProductReviews;
import io.reflectoring.jvcart.entity.product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductReviewRepository productReviewRepository;
	
	
	public Map<String,Object> getAllProducts(int page,int size){
		Pageable pageable = PageRequest.of(page,size);
		Page<product> products = productRepository.findAll(pageable);
		Map<String,Object> response = new HashMap<>();
		response.put("products",products.getContent());
		response.put("totalproducts",products.getTotalElements());
		return response;
	}
	
    public product getproductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
	
    public List<product> searchproduct(String category,Double minprice,Double maxprice,String Keyword,Double rate) {
    	@SuppressWarnings("removal")
		Specification <product> spec=Specification.where(ProductSpecification.hasCategory(category))
    			.and(ProductSpecification.priceBetween(minprice, maxprice))
    	        .and(ProductSpecification.hasNameOrDescriptionLike(Keyword))
    	        .and(ProductSpecification.ratingGreaterThan(rate));
    	return productRepository.findAll(spec);
    }
    
    public void addReview(ProductReviewDto reviewDto) {
    	product Product  = productRepository.findById(reviewDto.getProductId()).orElseThrow( () -> new RuntimeException("Product not found!") ) ;
    	ProductReviews review  = new ProductReviews();
    	review.setComment(reviewDto.getComment());
    	review.setRating(reviewDto.getRating());
    	review.setProduct(Product);
    	productReviewRepository.save(review);
    	
    	
    	
    }

}
