package tech.webfoods.foodStore.usecase;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.UpdateCustomerDTO;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

@AllArgsConstructor
@Service
public class UpdateCustomer {

    private final CustomerRepository customerRepository;

    private final ServiceClient serviceClient;

    private final PasswordEncoder encoder;


    public Customer execute(UpdateCustomerDTO updateCustomerDTO) {



        var customerFind = customerRepository.findById(updateCustomerDTO.getId()).get();

        Customer customer = Customer.customerBuilder()
                .id(updateCustomerDTO.getId())
                .name(updateCustomerDTO.getName() != null ? updateCustomerDTO.getName() : customerFind.getName())
                .lastName(updateCustomerDTO.getLastName() != null ? updateCustomerDTO.getLastName() : customerFind.getLastName())
                .phone(updateCustomerDTO.getPhone() != null ? updateCustomerDTO.getPhone() : customerFind.getPhone())
                .celPhone(updateCustomerDTO.getCelPhone() != null ? updateCustomerDTO.getCelPhone() : customerFind.getCelPhone())
                .birthDate(updateCustomerDTO.getBirthDate() != null ? updateCustomerDTO.getBirthDate() : customerFind.getBirthDate() )
                .build();

        return customerRepository.save(customer);

    }
}
