package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.repository.CustomerRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteCustomer {


    private final CustomerRepository customerRepository;

    private final DetailCustomer detailCustomer;
    public boolean execute(UUID id) {
        var customer = detailCustomer.execute(id);
        if (customer != null && customer.getStatus().equals(Status.ACTIVE)) {
            customer.setStatus(Status.INACTIVE);

            customerRepository.save(CustomerConverter.toEntity(customer));
            return customer.getStatus().equals(Status.INACTIVE);
        }
        return false;
    }
}
