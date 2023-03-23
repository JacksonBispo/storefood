package tech.webfoods.foodStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.webfoods.foodStore.model.Order;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public abstract class PersonDTO {
    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private String celPhone;

    private LocalDate birthDate;

    private List<AddressDTO> addressList;

    private List<Order> orders;


    public PersonDTO(String name, String lastName, String cpf, String phone, String celPhone, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phone = phone;
        this.celPhone = celPhone;
        this.birthDate = birthDate;
    }
}
