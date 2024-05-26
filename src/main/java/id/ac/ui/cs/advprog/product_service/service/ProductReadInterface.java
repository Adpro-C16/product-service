package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductReadInterface {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
