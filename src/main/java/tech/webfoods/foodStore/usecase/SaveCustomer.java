package tech.webfoods.foodStore.usecase;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.model.Address;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.model.User;
import tech.webfoods.foodStore.model.enums.Profile;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SaveCustomer {

    private final CustomerRepository personRepository;

    private final ServiceClient serviceClient;

    private final PasswordEncoder encoder;


    public Customer execute(SaveCustomerDTO customerDTO) {

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
                .status(Status.fromValue("ATIVO"))
                .orders(Collections.emptyList())
                .birthDate(customerDTO.getBirthDate())
                .addressList(List.of(address))
                .profiles(Set.of(Profile.CLIENT.getCod()))
                .build();
        User user = User.builder()
                .login(customerDTO.getLogin())
                .pass(encoder.encode(customerDTO.getPass()))
                .build();
        customer.setUser(user);
        address.setPerson(customer);
        return personRepository.save(customer);
    }


}
