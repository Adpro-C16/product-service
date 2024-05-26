package id.ac.ui.cs.advprog.product_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name="marketId")
    private Long marketId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private int productPrice;

    public Product() {}

    public Product(String productName, int productPrice, long marketId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.marketId = marketId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}
