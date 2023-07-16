package tech.webfoods.foodStore.dto;

import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateCustomerDTO {

    private Long id;

    private String name;

    private String lastName;

    private String phone;

    private String celPhone;

    @Past
    private LocalDate birthDate;

}
