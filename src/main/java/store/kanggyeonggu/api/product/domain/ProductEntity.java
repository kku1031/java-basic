package store.kanggyeonggu.api.product.domain;

import lombok.Data;

@Data
public class ProductEntity {

    private String productName;
    private String description;
    private String price;
    private String stock;

}
