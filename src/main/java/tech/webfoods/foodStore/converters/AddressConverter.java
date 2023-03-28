package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.model.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static List<AddressDTO> getAddressesToDto(List<Address> address) {
        return address.stream().map(AddressConverter::toDTO).collect(Collectors.toList());
    }

    public static List<Address> getAddressesToEntity(List<Address> addresses) {
        return addresses.stream().map(AddressConverter::toAddressesCustomer).collect(Collectors.toList());
    }

    public static AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .logradouro(address.getName())
                .complemento(address.getComplemento())
                .cep(address.getPostalCode())
                .bairro(address.getBairro())
                .localidade(address.getName())
                .uf(address.getUf())
                .build();
    }

    public static Address toEntity(AddressDTO address) {
        return Address.builder()
                .name(address.getLogradouro())
                .complemento(address.getComplemento())
                .postalCode(address.getCep())
                .bairro(address.getBairro())
                .city(address.getLocalidade())
                .uf(address.getUf())
                .build();
    }

    public static Address toAddressesCustomer(Address address) {
        return Address.builder()
                .name(address.getName())
                .complemento(address.getComplemento())
                .postalCode(address.getPostalCode())
                .bairro(address.getBairro())
                .city(address.getCity())
                .uf(address.getUf())
                .build();
    }
}
