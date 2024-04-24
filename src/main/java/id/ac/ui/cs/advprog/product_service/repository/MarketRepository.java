package id.ac.ui.cs.advprog.product_service.repository;

import id.ac.ui.cs.advprog.product_service.model.Market;
import id.ac.ui.cs.advprog.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    @Query("SELECT p FROM Product p WHERE p.market.marketId = :marketId")
    List<Product> getProductFromMarket(Long marketId);
}
