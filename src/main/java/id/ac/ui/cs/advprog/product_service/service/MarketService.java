package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.model.Market;
import id.ac.ui.cs.advprog.product_service.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    // Get all market
    public List<Market> findAll() {
        return marketRepository.findAll();
    }

    // Get market by id
    public Optional<Market> findById(@PathVariable Long id) {
        return marketRepository.findById(id);
    }

}
