package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.PersonDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.model.Address;
import tech.webfoods.foodStore.model.Cargo;
import tech.webfoods.foodStore.model.Customer;
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

    public static PersonDTO toDTO (Employee person){
        return PersonDTO.builder()
                .name(person.getName())
                .lastName(person.getLastName())
                .cpf(person.getCpf())
                .phone(person.getPhone())
                .celPhone(person.getCelPhone())
                .birthDate(person.getBirthDate())
                .addressList(AddressConverter.getAddressesToDto(person.getAddressList()))
                .cargo(CargoDtoConverter.toDTO(person.getCargo()))
                .build();
    }
}
