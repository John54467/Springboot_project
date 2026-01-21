package io.reflectoring.jvcart.Repository.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.jvcart.Service.ProductService;
import io.reflectoring.jvcart.entity.product;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping
	public Map<String,Object> getAllProducts(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="5")int size) {
		
		return productService.getAllProducts(page,size);
	}
	
	@GetMapping("/{id}")
	public product getproductById(@PathVariable Long id) {
		return productService.getproductById(id);
	}
	@GetMapping("/search")
	public List<product> searchproduct(@RequestParam(required = false) String category, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) String Keyword, @RequestParam(required = false) Double rate) {
		return productService.searchproduct(category, minPrice, maxPrice, Keyword, rate);
		
	}
	
}
