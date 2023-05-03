package tech.webfoods.foodStore.resources;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.webfoods.foodStore.converters.CategoryConverter;
import tech.webfoods.foodStore.dto.CategoryDTO;
import tech.webfoods.foodStore.usecase.SaveCategory;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearer-key")
public class CategoryResource {

    private SaveCategory saveCategory;


    @PostMapping(value = "/category/save")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        var category = saveCategory.execute(categoryDTO);
        return ResponseEntity.ok(CategoryConverter.toDTO(category));
    }
}
