package tech.webfoods.foodStore.dto;

import lombok.Builder;
import tech.webfoods.foodStore.model.Order;

import java.time.LocalDate;
import java.util.List;

public class CustomerDTO extends PersonDTO {

    @Builder(builderMethodName = "customerDTOBuilder")
    public CustomerDTO(String name, String lastName, String cpf, String phone, String celPhone, LocalDate birthDate, List<AddressDTO> addressList, List<Order> orders) {
        super(name, lastName, cpf, phone, celPhone, birthDate, addressList, orders);
    }
}

