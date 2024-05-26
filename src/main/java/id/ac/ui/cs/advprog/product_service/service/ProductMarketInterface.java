package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.model.Product;

import java.util.List;
public interface ProductMarketInterface {
    List<Product> findByMarketId(Long marketId);
}
