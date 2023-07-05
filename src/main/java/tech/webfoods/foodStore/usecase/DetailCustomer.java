package tech.webfoods.foodStore.usecase;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.CustomerDTO;
import tech.webfoods.foodStore.dto.EmployeeDTO;
import tech.webfoods.foodStore.model.Customer;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.repository.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DetailCustomer {

    private final CustomerRepository customerRepository;


        public CustomerDTO execute(UUID id){
            var employee = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            return CustomerConverter.toDTO(employee);
        }
}
