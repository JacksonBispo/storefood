package tech.webfoods.foodStore.usecase;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.webfoods.foodStore.dto.UpdateEmployeeDTO;
import tech.webfoods.foodStore.model.Employee;
import tech.webfoods.foodStore.repository.EmployeeRepository;
import tech.webfoods.foodStore.service.viaCep.ServiceClient;

@AllArgsConstructor
@Service
public class UpdateEmployee {

    private final EmployeeRepository employeeRepository;

    private final ServiceClient serviceClient;

    private final PasswordEncoder encoder;


    public Employee execute(UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employeeFind;
        employeeFind = employeeRepository.findById(updateEmployeeDTO.getId()).get();

        Employee employee = Employee.employeeBuilder()
                .id(updateEmployeeDTO.getId())
                .name(updateEmployeeDTO.getName() != null ? updateEmployeeDTO.getName() : employeeFind.getName())
                .lastName(updateEmployeeDTO.getLastName() != null ? updateEmployeeDTO.getLastName() : employeeFind.getLastName())
                .phone(updateEmployeeDTO.getPhone() != null ? updateEmployeeDTO.getPhone() : employeeFind.getPhone())
                .celPhone(updateEmployeeDTO.getCelPhone() != null ? updateEmployeeDTO.getCelPhone() : employeeFind.getCelPhone())
                .admissionDate(updateEmployeeDTO.getAdmissionDate() != null ? updateEmployeeDTO.getAdmissionDate() : employeeFind.getAdmissionDate())
                .build();

        return employeeRepository.save(employee);

    }
}
