package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.EmployeeDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.model.Address;
import tech.webfoods.foodStore.model.Cargo;
import tech.webfoods.foodStore.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeConverter {

    public static Employee toEntity(SaveEmployeeDTO employeeDTO) {
        List<Address> addressList = new ArrayList<>();

        return Employee.employeeBuilder()
                .id(null)
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .cpf(employeeDTO.getCpf())
                .phone(employeeDTO.getPhone())
                .celPhone(employeeDTO.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(employeeDTO.getBirthDate())
                .cargo(Cargo.builder()
                        .name(employeeDTO.getCargo())
                        .build())
                .addressList(List.of(
                        AddressConverter.toEntity(AddressDTO.builder()
                                .logradouro(employeeDTO.getPlaceName())
                                .complemento(employeeDTO.getComplemento())
                                .localidade(employeeDTO.getLocalidade())
                                .bairro(employeeDTO.getBairro())
                                .cep(employeeDTO.getPostalCode())
                                .uf(employeeDTO.getUf())
                                .build())))
                .build();

    }

    public static EmployeeDTO toDTO (Employee person){
        return EmployeeDTO.employeeDTOBuilder()
                .name(person.getName())
                .lastName(person.getLastName())
                .cpf(person.getCpf())
                .phone(person.getPhone())
                .celPhone(person.getCelPhone())
                .birthDate(person.getBirthDate())
                .addressList(AddressConverter.getAddressesToDto(person.getAddressList()))
                .cargoDTO(CargoDtoConverter.toDTO(person.getCargo()))
                .build();
    }
}