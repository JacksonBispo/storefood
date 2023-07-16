package tech.webfoods.foodStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String description;


    private BigDecimal price;

    private Long category;

    private String categoryName;

    private List<IngredientDTO> ingredients = new ArrayList<>();
}
