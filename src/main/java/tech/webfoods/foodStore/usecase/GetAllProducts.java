package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.ProductConverter;
import tech.webfoods.foodStore.model.Product;
import tech.webfoods.foodStore.repository.ProductRepository;

@AllArgsConstructor
@Service
public class GetAllProducts {

    private final ProductRepository productRepository;

    public Page<Product> execute(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductConverter::toEntityProduct);
    }
}
