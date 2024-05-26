package id.ac.ui.cs.advprog.product_service.controller;

import id.ac.ui.cs.advprog.product_service.model.Product;
import id.ac.ui.cs.advprog.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<Object> findAllProduct() {
        List<Product> productList = productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.<ResponseEntity<Object>>map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/market/{supermarketId}")
    public ResponseEntity<Object> findProductByMarket(@PathVariable Long supermarketId) {
        List<Product> productList = productService.findByMarketId(supermarketId);
        if (productList.isEmpty()) {
            return new ResponseEntity<>("No products found for market with id: " + supermarketId, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @PostMapping("/addProducts")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        try {
            Product addedProduct = productService.addProduct(product);
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            Product product = productService.updateProduct(id, updatedProduct);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable Long id) {
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

