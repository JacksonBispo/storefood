package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.CustomerDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.dto.UpdateCustomerDTO;
import tech.webfoods.foodStore.model.Customer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CustomerConverter {

    public static Customer toEntity(SaveCustomerDTO customerDTO) {
        return Customer.customerBuilder()
                .id(null)
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .cpf(customerDTO.getCpf())
                .phone(customerDTO.getPhone())
                .celPhone(customerDTO.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(customerDTO.getBirthDate())
                .addressList(List.of(
                        AddressConverter.toEntity(AddressDTO.builder()
                                .logradouro(customerDTO.getPlaceName())
                                .complemento(customerDTO.getComplemento())
                                .localidade(customerDTO.getLocalidade())
                                .bairro(customerDTO.getBairro())
                                .cep(customerDTO.getPostalCode())
                                .uf(customerDTO.getUf())
                                .build())))
                .build();

    }



    public static CustomerDTO toSaveCustomerDTO(Customer customer) {
        return CustomerDTO.customerDTOBuilder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .celPhone(customer.getCelPhone())
                .build();
    }
    public static Customer toEntity(CustomerDTO customerDTO) {
        return Customer.customerBuilder()
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .cpf(customerDTO.getCpf())
                .phone(customerDTO.getPhone())
                .celPhone(customerDTO.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(customerDTO.getBirthDate())
                .build();

    }

    public static Customer toCustomerEntity(Customer person) {
        return Customer.customerBuilder()
                .name(person.getName())
                .lastName(person.getLastName())
                .cpf(person.getCpf())
                .phone(person.getPhone())
                .celPhone(person.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(person.getBirthDate())
                .addressList(
                        AddressConverter.getAddressesToEntity(person.getAddressList()))
                .build();
    }


    public static CustomerDTO toDTO(Customer person) {
        return CustomerDTO.customerDTOBuilder()
                .name(person.getName())
                .lastName(person.getLastName())
                .cpf(person.getCpf())
                .phone(person.getPhone())
                .celPhone(person.getCelPhone())
                .status(person.getStatus())
                .birthDate(person.getBirthDate())
                .addressList(AddressConverter.getAddressesToDto(person.getAddressList()))
                .build();
    }

    public static UpdateCustomerDTO toUpdateDTO(Customer customer) {
        return UpdateCustomerDTO.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .celPhone(customer.getCelPhone())
                .build();
    }
}
