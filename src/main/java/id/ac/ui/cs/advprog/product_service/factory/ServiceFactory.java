package id.ac.ui.cs.advprog.product_service.factory;

import id.ac.ui.cs.advprog.product_service.service.ProductReadInterface;
import id.ac.ui.cs.advprog.product_service.service.ProductWriteInterface;
import id.ac.ui.cs.advprog.product_service.service.ProductMarketInterface;

public interface ServiceFactory {
    ProductReadInterface getProductReadInterface();
    ProductWriteInterface getProductWriteInterface();
    ProductMarketInterface getProductMarketInterface();
}
