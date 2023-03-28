package tech.webfoods.foodStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.webfoods.foodStore.model.Order;

import java.util.List;

@AllArgsConstructor
@Data
public abstract class PersonDTO {
    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private String celPhone;


    private List<AddressDTO> addressList;

    private List<Order> orders;

}
