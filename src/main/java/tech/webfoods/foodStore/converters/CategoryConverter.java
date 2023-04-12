package tech.webfoods.foodStore.converters;

import tech.webfoods.foodStore.dto.CategoryDTO;
import tech.webfoods.foodStore.model.Category;

public class CategoryConverter {

    public static Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .build();
    }
}
