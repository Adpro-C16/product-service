package id.ac.ui.cs.advprog.product_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marketId", referencedColumnName = "marketId")
    private Market market;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private int productPrice;

    @Column(name = "productStock")
    private int productStock;

    public Product() {}

    public Product(String productName, int productPrice, int productStock, Market market) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.market = market;
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

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
