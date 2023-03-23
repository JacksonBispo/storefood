package tech.webfoods.foodStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveEmployeeDTO extends  SavePersonDTO{
    private String cargo;

}
