package id.ac.ui.cs.advprog.product_service;

import id.ac.ui.cs.advprog.product_service.model.Product;
import id.ac.ui.cs.advprog.product_service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;
	@Bean
	public CommandLineRunner demoCommandLineRunner() {
		return args -> {
			System.out.println("Running......");

			Product p1 = new Product("Product A", 100000,1);
			Product p2 = new Product("Product B", 200000, 2);
			Product p3 = new Product("Product C", 300000, 1);
			Product p4 = new Product("Product D", 400000, 1);
			Product p5 = new Product("Product E", 500000, 2);
			productRepository.saveAll(List.of(p1,p2,p3,p4,p5));
		};
	}
}

