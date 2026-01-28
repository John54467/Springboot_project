package io.reflectoring.jvcart.seed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.reflectoring.jvcart.Repository.ProductRepository;
import io.reflectoring.jvcart.entity.product;

@Component
public class Productseed implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(productRepository.count()==0) {
			List<product> demoproduct = List.of(
	                new product(null, "iPhone 15", 799.0, "Latest Apple phone","Electornic", 4.8, "Amazon", 10, 0,List.of("/Product/1.jfif")),
	                new product(null, "Samsung S24", 899.99, "AI-powered flagship","cromo",4.7, "Best Buy", 15, 0,List.of("/Product/2.jfif")),
	                new product(null, "Sony WH-1000XM5", 348.0, "Noise cancelling headphones","Mobiles", 4.9, "Walmart", 25, 0,List.of("/Product/3.jfif")),
	                new product(null, "Kindle Paperwhite", 149.0, "Waterproof e-reader","games", 4.6, "Amazon", 50, 0,List.of("/Product/4.jfif")),
	                new product(null, "Logitech MX Master 3S", 99.0, "Ergonomic wireless mouse","Playstation", 4.8, "Newegg", 30, 0,List.of("/Product/5.jfif"))
	            );
			productRepository.saveAll(demoproduct);
			System.out.println("Seeded Demo Product");
		}
		else {
			System.out.println("Product already existed");
		}
		
	}

	
}
