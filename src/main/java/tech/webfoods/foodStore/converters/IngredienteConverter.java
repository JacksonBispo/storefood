package tech.webfoods.foodStore.converters;

import tech.webfoods.foodStore.dto.IngredientDTO;
import tech.webfoods.foodStore.model.Ingredient;

public class IngredienteConverter {

    public static Ingredient toEntity(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .description(ingredientDTO.getDescription())
                .price(ingredientDTO.getPrice())
                .build();
    }

    public static Ingredient toEntity(Ingredient ingredientDTO) {
        return Ingredient.builder()
                .description(ingredientDTO.getDescription())
                .price(ingredientDTO.getPrice())
                .build();
    }

    public static IngredientDTO toDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .description(ingredient.getDescription())
                .price(ingredient.getPrice())
                .build();
    }
}
