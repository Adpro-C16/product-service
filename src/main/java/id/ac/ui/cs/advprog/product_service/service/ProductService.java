package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.model.Product;
import id.ac.ui.cs.advprog.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Get all product
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Get product by id
    public Optional<Product> findById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // Add Product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
