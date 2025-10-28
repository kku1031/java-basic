package store.kanggyeonggu.api.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    private String productName;
    private String description;
    private String price;
    private String stock;

}
