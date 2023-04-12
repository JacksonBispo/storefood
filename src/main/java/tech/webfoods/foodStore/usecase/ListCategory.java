package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.model.Category;
import tech.webfoods.foodStore.repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ListCategory {

    private CategoryRepository categoryRepository;

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
