package id.ac.ui.cs.advprog.product_service.repository;

import id.ac.ui.cs.advprog.product_service.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
