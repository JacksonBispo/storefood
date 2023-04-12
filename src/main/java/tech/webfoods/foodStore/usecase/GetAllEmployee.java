package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.viaCep.ServiceClient;

@AllArgsConstructor
@Service
public class GetAllEmployee {

    private final EmployeeRepository personRepository;

    public Page<Employee> execute(Pageable pegPageable) {
        return personRepository.findAll(pegPageable).map(EmployeeConverter::toEmployeeEntity);
    }


}
