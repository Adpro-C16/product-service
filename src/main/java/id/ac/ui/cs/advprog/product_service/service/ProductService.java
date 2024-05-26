package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.model.Product;
import id.ac.ui.cs.advprog.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductReadInterface, ProductWriteInterface, ProductMarketInterface {
    @Autowired
    private ProductRepository productRepository;

    // Get all product
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Get product by id
    @Override
    public Optional<Product> findById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // Add Product
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update Product
    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Product> updatedProduct = productRepository.findById(productId);
        if (updatedProduct.isPresent()) {
            Product product1 = updatedProduct.get();
            product1.setProductName(product.getProductName());
            product1.setProductPrice(product.getProductPrice());
            return productRepository.save(product1);
        } else {
            throw new IllegalArgumentException("Product not found with id: " + productId);
        }
    }

    // Delete Product by ID
    @Override
    public void deleteProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.deleteById(productId);
        } else {
            throw new IllegalArgumentException("Product not found with id: " + productId);
        }
    }

    // Find product by MarketId
    @Override
    public List<Product> findByMarketId(Long marketId) {
        return productRepository.findByMarketId(marketId);
    }
}
