package tech.webfoods.foodStore.service;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.model.Address;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.repository.AddressRepository;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.repository.PersonRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository personRepository;

    private final ServiceClient serviceClient;


    private final AddressRepository addressRepository;


    public Customer save(SaveCustomerDTO customerDTO){
        AddressDTO addressDTO = serviceClient.buscaEnderecoPorCep(customerDTO.getPostalCode());
        customerDTO.setPlaceName(addressDTO.getLogradouro());
        customerDTO.setComplemento(addressDTO.getComplemento());
        customerDTO.setBairro(addressDTO.getBairro());
        customerDTO.setLocalidade(addressDTO.getLocalidade());
        customerDTO.setUf(addressDTO.getUf());
        customerDTO.setCity(addressDTO.getLocalidade());

        Address address = Address.builder()
                .name(customerDTO.getPlaceName())
                .number(customerDTO.getNumber())
                .complemento(customerDTO.getComplemento())
                .postalCode(customerDTO.getPostalCode())
                .bairro(customerDTO.getBairro())
                .city(customerDTO.getCity())
                .uf(customerDTO.getUf())
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
                .addressList(List.of(address))
                .build();
        address.setPerson(customer);
     return personRepository.save(customer);
    }

    public Page<Customer> getAllPersons(Pageable pegPageable) {
        var list = personRepository.findAll(pegPageable).map(CustomerConverter::toCustomerDTO);
        return list;
    }


}
