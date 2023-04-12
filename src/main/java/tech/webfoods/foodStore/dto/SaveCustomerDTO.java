package tech.webfoods.foodStore.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveCustomerDTO extends SavePersonDTO {

    @NotNull
    @Past
    private LocalDate birthDate;

}
