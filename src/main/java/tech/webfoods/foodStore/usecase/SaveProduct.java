package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.ProductConverter;
import tech.webfoods.foodStore.dto.ProductDTO;
import tech.webfoods.foodStore.repository.IngredientRepository;
import tech.webfoods.foodStore.repository.ProductRepository;

@Service
@AllArgsConstructor
public class SaveProduct {

    private final ProductRepository productRepository;

    private final IngredientRepository ingredientRepository;

    public ResponseEntity<ProductDTO> execute(ProductDTO productDTO) {

        var product = ProductConverter.toEntity(productDTO);
         productRepository.save(product);
         ingredientRepository.saveAll(product.getIngredients());
        return ResponseEntity.ok().build();
    }
}
