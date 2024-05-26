package id.ac.ui.cs.advprog.product_service.repository;

import id.ac.ui.cs.advprog.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.productId = :productId")
    void deleteProductFromMarketById(Long productId);

    List<Product> findByMarketId(Long marketId);
}
