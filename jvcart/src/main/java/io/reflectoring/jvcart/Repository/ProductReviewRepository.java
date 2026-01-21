package io.reflectoring.jvcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.reflectoring.jvcart.entity.ProductReviews;

public interface ProductReviewRepository extends JpaRepository<ProductReviews,Long>{

}
