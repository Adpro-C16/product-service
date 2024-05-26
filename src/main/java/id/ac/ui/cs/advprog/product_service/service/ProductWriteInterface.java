package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.model.Product;

public interface ProductWriteInterface {
    Product addProduct(Product product);
    Product updateProduct(Long productId, Product product);
    void deleteProductById(Long productId);
}
