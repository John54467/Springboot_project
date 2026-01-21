package io.reflectoring.jvcart.ProductSpecification;

import org.springframework.data.jpa.domain.Specification;

import io.reflectoring.jvcart.entity.product;

public class ProductSpecification {
	
	public static Specification <product> hasCategory(String category){
		return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"),category);
	}
	
	public static Specification <product>priceBetween(Double min , Double max ){
		return (root, query, cb) ->{
			if(min==null && max==null)return null;
			if(min==null) return cb.lessThanOrEqualTo(root.get("price"),max);
			if(max==null) return cb.greaterThanOrEqualTo(root.get("price"),min);
			return cb.between(root.get("price"),min,max);
		};
	}
	
	public static Specification<product> hasNameOrDescriptionLike(String Keyword){
		return (root, query, cb) -> { 
		if(Keyword == null || Keyword.isEmpty()) return null;
		return cb.or(
				cb.like(root.get("name"), "%"+Keyword.toLowerCase()+"%"),
				cb.like(root.get("description"), "%"+Keyword.toLowerCase()+"%")
				);
		};
			
		}
	public static Specification<product> ratingGreaterThan(Double rate) {
		if(rate == null) return null;
		return (root, query, cb) -> { 
			return cb.greaterThanOrEqualTo(root.get("rate"), rate);
		};
	}
			
		}
	


