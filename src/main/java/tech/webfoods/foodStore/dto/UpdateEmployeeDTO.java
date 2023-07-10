package tech.webfoods.foodStore.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateEmployeeDTO {

    private UUID id;

    private String name;

    private String lastName;

    private String phone;

    private String celPhone;

    @Future
    private LocalDate admissionDate;

}
