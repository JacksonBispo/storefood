package tech.webfoods.foodStore.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.model.Status;
import tech.webfoods.foodStore.repository.CustomerRepository;
import tech.webfoods.foodStore.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class DeleteEmployee {


    private final EmployeeRepository employeeRepository;

    private final DetailCustomer detailCustomer;
    public boolean execute(Long id) {
        var employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setStatus(Status.INACTIVE);

            employeeRepository.save(employee.get());
            return employee.get().getStatus().equals(Status.INACTIVE);
        }
        return false;
    }
}
