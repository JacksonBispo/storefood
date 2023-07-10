package tech.webfoods.foodStore.usecase;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.UpdateCustomerDTO;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

import java.util.Collections;

@AllArgsConstructor
@Service
public class UpdateEmployee {

    private final CustomerRepository personRepository;

    private final ServiceClient serviceClient;

    private final PasswordEncoder encoder;


    public Customer execute(UpdateCustomerDTO updateCustomerDTO) {


        Customer customer = Customer.customerBuilder()
                .id(updateCustomerDTO.getId())
                .name(updateCustomerDTO.getName())
                .lastName(updateCustomerDTO.getLastName())
                .phone(updateCustomerDTO.getPhone())
                .celPhone(updateCustomerDTO.getCelPhone())
                .orders(Collections.emptyList())
                .birthDate(updateCustomerDTO.getBirthDate())
                .build();

        return personRepository.save(customer);
    }

}
