package tech.webfoods.foodStore.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SaveEmployeeDTO {

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
    private String cargo;

}
