package tech.webfoods.foodStore.dto;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data

public class CategoryDTO {

    private Long id;

    private String name;
}
