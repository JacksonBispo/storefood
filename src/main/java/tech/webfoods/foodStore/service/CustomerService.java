package tech.webfoods.foodStore.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.model.*;
import tech.webfoods.foodStore.repository.AddressRepository;
import tech.webfoods.foodStore.repository.CityRepository;
import tech.webfoods.foodStore.repository.PersonRepository;
import tech.webfoods.foodStore.repository.StateRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private final PersonRepository personRepository;

    private final ServiceClient serviceClient;

    private final CityRepository cityRepository;

    private final StateRepository stateRepository;

    private final AddressRepository addressRepository;


    public Customer save(SaveCustomerDTO customerDTO){
        AddressDTO addressDTO = serviceClient.buscaEnderecoPorCep(customerDTO.getPostalCode());
        customerDTO.setPlaceName(addressDTO.getLogradouro());
        customerDTO.setComplemento(addressDTO.getComplemento());
        customerDTO.setBairro(addressDTO.getBairro());
        customerDTO.setLocalidade(addressDTO.getLocalidade());
        customerDTO.setUf(addressDTO.getUf());
        customerDTO.setCity(addressDTO.getLocalidade());

        Address address = addressRepository.findBypostalCode(customerDTO.getPostalCode());


        State state = stateRepository.findByDsSigla(customerDTO.getUf());

        State newState =  State.builder()
                .dsSigla(customerDTO.getUf())
                .build();

      City city = cityRepository.findByName(customerDTO.getLocalidade());

        City newCity = City.builder()
                .name(customerDTO.getLocalidade())
                .state(state != null ? state : newState)
                .build();

        District district = District.builder()
                .name(customerDTO.getBairro())
                .cidade(city != null ? city : newCity)
                .build();

        Address newAddress = Address.builder()
                .name(customerDTO.getPlaceName())
                .number(customerDTO.getNumber())
                .complemento(customerDTO.getComplemento())
                .postalCode(customerDTO.getPostalCode())
                .district(district)
                .build();


        Customer customer = Customer.customerBuilder()
                .id(null)
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .cpf(customerDTO.getCpf())
                .phone(customerDTO.getPhone())
                .celPhone(customerDTO.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(customerDTO.getBirthDate())
                .addressList(List.of(address != null ? address : newAddress))
                .build();
                 newAddress.setPerson(customer);

     return personRepository.save(customer);
    }
}
