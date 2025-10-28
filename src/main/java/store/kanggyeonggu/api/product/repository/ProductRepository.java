package store.kanggyeonggu.api.product.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.product.domain.ProductDTO;

@Repository
public class ProductRepository {

    private List<ProductDTO> savedProducts = new ArrayList<>();

    public List<ProductDTO> getAllSavedProducts() {
        return new ArrayList<>(savedProducts);
    }

    public Messenger save(ProductDTO product) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger saveAll(List<ProductDTO> products) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger update(ProductDTO product) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        return messenger;
    }

}
