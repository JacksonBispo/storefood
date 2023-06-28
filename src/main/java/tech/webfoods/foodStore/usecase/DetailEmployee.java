package tech.webfoods.foodStore.usecase;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.CustomerDTO;
import tech.webfoods.foodStore.dto.EmployeeDTO;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class DetailEmployee {

    private final EmployeeRepository employeeRepository;

    public EmployeeDTO execute(Long id){
        var employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return EmployeeConverter.toDTO(employee);
    }
}
