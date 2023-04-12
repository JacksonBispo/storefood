package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CategoryConverter;
import tech.webfoods.foodStore.dto.CategoryDTO;
import tech.webfoods.foodStore.model.Category;
import tech.webfoods.foodStore.repository.CategoryRepository;

@Service
@AllArgsConstructor
public class SaveCategory {

    private CategoryRepository categoryRepository;

    public Category execute(CategoryDTO categoryDTO){
       return categoryRepository.save(CategoryConverter.toEntity(categoryDTO));
    }
}
