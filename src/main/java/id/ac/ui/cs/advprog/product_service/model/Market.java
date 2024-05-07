package id.ac.ui.cs.advprog.product_service.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// Cuma dummy
@Entity
@Table(name = "markets")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long marketId;

    @Column(name = "marketName")
    private String marketName;

    @Column(name = "balance")
    private int balance;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private List<Product> productList;

    public Market() {}
    public Market(String marketName) {
        this.marketName = marketName;
        this.balance = 0;
        this.productList = new ArrayList<>();
    }

    public long getMarketId() {
        return marketId;
    }

    public void setMarketId(long marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
