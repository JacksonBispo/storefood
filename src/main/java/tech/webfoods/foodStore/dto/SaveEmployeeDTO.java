package tech.webfoods.foodStore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
    @Email(message = "o login deve ser um email válido!")
    private String login;
    @NotEmpty
    @Length(min = 7, message = "a senha deve ter no mínimo 7 caracteres")
    private String pass;

    @NotBlank
    private String cargo;

    @Future
    private LocalDate admissionDate;


}
