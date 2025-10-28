package store.kanggyeonggu.api.product.service;

import java.util.List;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.product.domain.ProductDTO;

public interface ProductService {

    Messenger save(ProductDTO product);

    Messenger saveAll(List<ProductDTO> products);

    Messenger update(ProductDTO product);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    List<ProductDTO> getAllSavedProducts();
}
