package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

@AllArgsConstructor
@Service
public class GetAllCustomers {

    private final CustomerRepository personRepository;

    public Page<Customer> execute(Pageable pegPageable) {
        return personRepository.findByStatus(pegPageable, Status.ACTIVE).map(CustomerConverter::toCustomerEntity);
    }

}
