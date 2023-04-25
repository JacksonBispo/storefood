package tech.webfoods.foodStore.usecase;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.dto.CustomerDTO;
import tech.webfoods.foodStore.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class DetailCustomer {

    private final CustomerRepository customerRepository;

    public CustomerDTO detailCustomer(Long id){
        var customer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return CustomerConverter.toDTO(customer);
    }
}
