package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class DeleteCustomer {


    private final CustomerRepository customerRepository;

    private final DetailCustomer detailCustomer;
    public boolean execute(Long id) {
        var customer = customerRepository.findById(id);
        if (customer.isPresent()&& customer.get().getStatus().equals(Status.ACTIVE)) {
            customer.get().setStatus(Status.INACTIVE);

            customerRepository.save(customer.get());
            return customer.get().getStatus().equals(Status.INACTIVE);
        }
        return false;
    }
}
