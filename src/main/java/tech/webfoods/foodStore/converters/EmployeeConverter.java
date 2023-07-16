package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.EmployeeDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.dto.UpdateEmployeeDTO;
import tech.webfoods.foodStore.model.Cargo;
import tech.webfoods.foodStore.model.Employee;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class EmployeeConverter {

    public static Employee toEntity(SaveEmployeeDTO employeeDTO) {

        return Employee.employeeBuilder()
                .id(null)
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .cpf(employeeDTO.getCpf())
                .phone(employeeDTO.getPhone())
                .celPhone(employeeDTO.getCelPhone())
                .orders(Collections.emptyList())
                .admissionDate(LocalDate.now())
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

    public static EmployeeDTO toDTO(Employee person) {
        return EmployeeDTO.employeeDTOBuilder()
                .name(person.getName())
                .lastName(person.getLastName())
                .cpf(person.getCpf())
                .phone(person.getPhone())
                .celPhone(person.getCelPhone())
                .admissionDate(person.getAdmissionDate())
                .addressList(AddressConverter.getAddressesToDto(person.getAddressList()))
                .cargoDTO(CargoDtoConverter.toDTO(person.getCargo()))
                .build();
    }

    public static UpdateEmployeeDTO toUpdateDTO(Employee employee) {
        return UpdateEmployeeDTO.builder()
                .name(employee.getName())
                .lastName(employee.getLastName())
                .phone(employee.getPhone())
                .celPhone(employee.getCelPhone())
                .admissionDate(employee.getAdmissionDate())
                .build();
    }

    public static Employee toEmployeeEntity(Employee person) {
        return Employee.employeeBuilder()
                .name(person.getName())
                .lastName(person.getLastName())
                .cpf(person.getCpf())
                .phone(person.getPhone())
                .celPhone(person.getCelPhone())
                .orders(Collections.emptyList())
                .admissionDate(person.getAdmissionDate())
                .addressList(
                        AddressConverter.getAddressesToEntity(person.getAddressList()))
                .cargo(person.getCargo())
                .build();
    }
}
