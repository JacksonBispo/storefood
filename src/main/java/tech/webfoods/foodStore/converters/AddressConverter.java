package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.model.Address;
import tech.webfoods.foodStore.model.City;
import tech.webfoods.foodStore.model.District;
import tech.webfoods.foodStore.model.State;

import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static List<AddressDTO> getAddressesToDto(List<Address> address) {
        return address.stream().map(AddressConverter::toDTO).collect(Collectors.toList());
    }

    public static List<Address> getAddressesToEntity(List<AddressDTO> addressDTO) {
        return addressDTO.stream().map(AddressConverter::toEntity).collect(Collectors.toList());
    }

    public static AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .logradouro(address.getName())
                .complemento(address.getComplemento())
                .cep(address.getPostalCode())
                .bairro(address.getDistrict().getName())
                .localidade(address.getDistrict().getCidade().getName())
                .uf(address.getDistrict().getCidade().getState().getDsSigla())
                .build();
    }

    public static Address toEntity(AddressDTO address) {
        return Address.builder()
                .name(address.getLogradouro())
                .complemento(address.getComplemento())
                .postalCode(address.getCep())
                .district(District.builder()
                        .name(address.getBairro())
                        .cidade(City.builder()
                                .state(State.builder()
                                        .dsSigla(address.getUf())
                                        .build())
                                .build()).build())
                .build();
    }
}
