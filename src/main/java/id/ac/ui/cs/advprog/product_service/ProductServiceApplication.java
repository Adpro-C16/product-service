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

			Product p1 = new Product("1", "Product A", 100000, 12);
			Product p2 = new Product("2", "Product B", 200000, 13);

			productRepository.saveAll(List.of(p1,p2));
		};
	}
}

