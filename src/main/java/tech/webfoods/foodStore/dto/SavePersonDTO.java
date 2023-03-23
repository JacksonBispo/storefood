package tech.webfoods.foodStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SavePersonDTO {

    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private String celPhone;
    private LocalDate birthDate;
    private String postalCode;
    private String number;
    private String placeName;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String city;

}
