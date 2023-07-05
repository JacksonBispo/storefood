package tech.webfoods.foodStore.usecase;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.AddressDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.dto.UpdateCustomerDTO;
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
public class UpdateCustomer {

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
