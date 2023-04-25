package tech.webfoods.foodStore.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class SaveEmployeeDTO {

    @NotBlank(message = "o nome é obrigatório!")
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String cpf;


    @NotBlank
    private String phone;


    @NotBlank
    private String celPhone;


    @NotBlank
    private String postalCode;

    private String number;

    private String placeName;

    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String city;

    @NotBlank
    private String cargo;

    @Future
    private LocalDate admissionDate;


}
