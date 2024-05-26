package id.ac.ui.cs.advprog.product_service.factory;

import id.ac.ui.cs.advprog.product_service.service.ProductReadInterface;
import id.ac.ui.cs.advprog.product_service.service.ProductWriteInterface;
import id.ac.ui.cs.advprog.product_service.service.ProductMarketInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

    private final ProductReadInterface productReadInterface;
    private final ProductWriteInterface productWriteInterface;
    private final ProductMarketInterface productMarketInterface;

    @Autowired
    public ServiceFactoryImpl(ProductReadInterface productReadInterface, ProductWriteInterface productWriteInterface, ProductMarketInterface productMarketInterface) {
        this.productReadInterface = productReadInterface;
        this.productWriteInterface = productWriteInterface;
        this.productMarketInterface = productMarketInterface;
    }

    @Override
    public ProductReadInterface getProductReadInterface() {
        return productReadInterface;
    }

    @Override
    public ProductWriteInterface getProductWriteInterface() {
        return productWriteInterface;
    }

    @Override
    public ProductMarketInterface getProductMarketInterface() {
        return productMarketInterface;
    }
}
