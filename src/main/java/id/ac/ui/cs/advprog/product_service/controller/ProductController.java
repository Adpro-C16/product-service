package id.ac.ui.cs.advprog.product_service.controller;

import id.ac.ui.cs.advprog.product_service.model.Market;
import id.ac.ui.cs.advprog.product_service.model.Product;
import id.ac.ui.cs.advprog.product_service.service.MarketService;
import id.ac.ui.cs.advprog.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<Product> findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

}

@RestController
@RequestMapping("/markets")
class MarketController {
    @Autowired
    private MarketService marketService;

    @GetMapping
    public ResponseEntity<Object> findAllMarket() {
        List<Market> marketList = marketService.findAll();
        return new ResponseEntity<>(marketList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Market> findMarketById(@PathVariable Long id) {
        return marketService.findById(id);
    }
}