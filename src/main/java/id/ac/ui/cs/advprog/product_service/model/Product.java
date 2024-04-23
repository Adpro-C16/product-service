package id.ac.ui.cs.advprog.product_service.model;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Product {
    private String productId;
    private String marketId;
    private String productName;
    private int productPrice;
    private int productStock;
}
