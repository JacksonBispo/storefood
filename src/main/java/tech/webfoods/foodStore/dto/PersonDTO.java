package tech.webfoods.foodStore.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tech.webfoods.foodStore.model.Cargo;
import tech.webfoods.foodStore.model.Order;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonDTO {
    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private String celPhone;

    private LocalDate birthDate;

    private List<AddressDTO> addressList;

    private CargoDTO cargo;

    private List<Order> orders;

}
