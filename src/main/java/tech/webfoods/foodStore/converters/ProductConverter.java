package tech.webfoods.foodStore.converters;

import tech.webfoods.foodStore.dto.ProductDTO;
import tech.webfoods.foodStore.model.Category;
import tech.webfoods.foodStore.model.Product;

public class ProductConverter {

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .description(product.getDescription())
                .price(product.getPrice())
                .ingredients(product.getIngredients().stream().map(IngredienteConverter::toDTO).toList())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .ingredients(productDTO.getIngredients().stream().map(IngredienteConverter::toEntity).toList())
                .category(Category.builder()
                        .id(productDTO.getCategory())
                        .name(null)
                        .products(null)
                        .build())
                .build();
    }

    public static Product toEntityProduct(Product productDTO) {
        return Product.builder()
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .ingredients(productDTO.getIngredients().stream().map(IngredienteConverter::toEntity).toList())
                .category(productDTO.getCategory())
                .build();
    }
}
