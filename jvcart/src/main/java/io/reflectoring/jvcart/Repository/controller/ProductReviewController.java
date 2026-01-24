package io.reflectoring.jvcart.Repository.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.jvcart.Dto.ProductReviewDto;
import io.reflectoring.jvcart.Service.ProductService;

@RestController
@RequestMapping("api/product/reviews")
public class ProductReviewController {
    private final ProductService productService;

    public ProductReviewController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ProductReviewDto reviewDto){
        // Basic validation: productId is required
        if (reviewDto == null || reviewDto.getProductId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("productId must be provided");
        }

        productService.addReview(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review added");
    }

}