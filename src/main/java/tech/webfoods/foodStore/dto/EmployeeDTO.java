package tech.webfoods.foodStore.dto;

import lombok.Builder;
import tech.webfoods.foodStore.model.Order;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDTO extends PersonDTO {


    private CargoDTO cargoDTO;

    @Builder(builderMethodName = "employeeDTOBuilder")
    public EmployeeDTO(String name, String lastName, String cpf, String phone, String celPhone, LocalDate birthDate, List<AddressDTO> addressList, List<Order> orders, CargoDTO cargoDTO) {
        super(name, lastName, cpf, phone, celPhone, birthDate, addressList, orders);
        this.cargoDTO = cargoDTO;
    }
}
