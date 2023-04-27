package tech.webfoods.foodStore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCustomerDTO {

    @NotBlank(message = "o nome é obrigatório!")
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @CPF
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
    @Email
    private String login;

    @NotBlank
    @Length(min = 7)
    private String pass;

    @NotNull
    @Past
    private LocalDate birthDate;

}
