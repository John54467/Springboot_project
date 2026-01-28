package io.reflectoring.jvcart.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.reflectoring.jvcart.Dto.ProductDto;
import io.reflectoring.jvcart.Dto.ProductImageDto;
import io.reflectoring.jvcart.Dto.ProductReviewDto;
import io.reflectoring.jvcart.ProductSpecification.ProductSpecification;
import io.reflectoring.jvcart.Repository.ProductRepository;
import io.reflectoring.jvcart.Repository.ProductReviewRepository;
import io.reflectoring.jvcart.entity.ProductReviews;
import io.reflectoring.jvcart.entity.product;

@Service
public class ProductService {
    private static final ProductImageDto Images = null;
	private final ProductRepository productRepository;
    private final ProductReviewRepository productReviewRepository;

    public ProductService(ProductRepository productRepository, ProductReviewRepository productReviewRepository) {
        this.productRepository = productRepository;
        this.productReviewRepository = productReviewRepository;
    }

    public Map<String,Object> getAllProducts(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<product> products = productRepository.findAll(pageable);
        List<ProductDto> productDtos = products.stream().map(this::ConvertToDto).collect(Collectors.toList()); 
        Map<String,Object> response = new HashMap<>();
        response.put("products",productDtos);
        response.put("totalproducts",products.getTotalElements());
        return response;
    }
    
    public ProductDto ConvertToDto(product Product){
    	ProductDto dto = new ProductDto();
    	dto.setId(Product.getId());
    	dto.setName(Product.getName());
    	dto.setPrice(Product.getPrice());
    	dto.setDescription(Product.getDescription());
    	dto.setCategory(Product.getCategory());
    	dto.setRating(Product.getRating());
    	dto.setSeller(Product.getSeller());
    	dto.setStock(Product.getStock());
    	dto.setNumsofReviews(Product.getNumsofReviews());
		List<ProductReviewDto>  reviewDtos = Product.getReviews().stream().map(review -> {
			ProductReviewDto reviewDto = new ProductReviewDto();
			reviewDto.setProductId(review.getId());
			reviewDto.setComment(review.getComment());
			reviewDto.setRating(review.getRating());
			return reviewDto;
		}).collect(Collectors.toList());
		
		dto.setReviews(reviewDtos);
		
		List<ProductImageDto>  ImagesDtos = Product.getImages().stream().map(review -> {
			ProductImageDto ImageDto = new ProductImageDto(Images.getUrl());
			return ImageDto;
		}).collect(Collectors.toList());
		
		dto.setImages(ImagesDtos);
    	return dto;
   
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
        // Defensive validation: ensure DTO and productId are present
        if (reviewDto == null || reviewDto.getProductId() == null) {
            throw new IllegalArgumentException("productId must be provided");
        }
        product Product  = productRepository.findById(reviewDto.getProductId()).orElseThrow( () -> new RuntimeException("Product not found!") ) ;
        ProductReviews review  = new ProductReviews();
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setProduct(Product);
        productReviewRepository.save(review);



    }

}