package tech.webfoods.foodStore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tech.webfoods.foodStore.model.Order;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CustomerDTO extends PersonDTO {


    private LocalDate birthDate;

    @Builder(builderMethodName = "customerDTOBuilder")
    public CustomerDTO(String name, String lastName, String cpf, String phone, String celPhone, List<AddressDTO> addressList, List<Order> orders, LocalDate birthDate) {
        super(name, lastName, cpf, phone, celPhone, addressList, orders);
        this.birthDate = birthDate;
    }
}

