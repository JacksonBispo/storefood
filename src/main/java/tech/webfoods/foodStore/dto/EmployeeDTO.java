package tech.webfoods.foodStore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tech.webfoods.foodStore.model.Order;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EmployeeDTO extends PersonDTO {


    private CargoDTO cargoDTO;

    private LocalDate admissionDate;

    @Builder(builderMethodName = "employeeDTOBuilder")

    public EmployeeDTO(Long id,String name, String lastName, String cpf, String phone, String celPhone, List<AddressDTO> addressList, List<Order> orders, CargoDTO cargoDTO, LocalDate admissionDate) {
        super(id, name, lastName, cpf, phone, celPhone, addressList, orders);
        this.cargoDTO = cargoDTO;
        this.admissionDate = admissionDate;
    }
}
