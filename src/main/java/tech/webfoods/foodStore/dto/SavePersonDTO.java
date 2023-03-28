package tech.webfoods.foodStore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SavePersonDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "cpf invalido!")
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

}
