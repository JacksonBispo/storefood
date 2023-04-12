package tech.webfoods.foodStore.resources;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.*;
import tech.webfoods.foodStore.usecase.GetAllCustomers;
import tech.webfoods.foodStore.usecase.GetAllEmployee;
import tech.webfoods.foodStore.usecase.SaveCustomer;
import tech.webfoods.foodStore.usecase.SaveEmployee;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PersonResource {

    private final SaveCustomer saveCustomer;

    private final GetAllCustomers getAllCustomers;

    private final GetAllEmployee getAllEmployee;

    private final SaveEmployee employeeService;


    @PostMapping(value = "/customer/save")
    public ResponseEntity<PersonDTO> saveCustomer(@RequestBody @Valid SaveCustomerDTO customerDTO) {
        var customer = saveCustomer.save(customerDTO);
        return ResponseEntity.ok(CustomerConverter.toDTO(customer));
    }

    @PostMapping(value = "/employee/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody @Valid SaveEmployeeDTO saveEmployeeDTO) {
        var employee = employeeService.execute(saveEmployeeDTO);
        return ResponseEntity.ok(EmployeeConverter.toDTO(employee));
    }

    @GetMapping(value = "/customer/customers")
    public ResponseEntity<Page<CustomerDTO>> listCustomer(
            @PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var list = getAllCustomers.execute(pageable).map(CustomerConverter::toDTO);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/employee/employers")
    public ResponseEntity<Page<EmployeeDTO>> listEmployee(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var list = getAllEmployee.execute(pageable).map(EmployeeConverter::toDTO);
        return ResponseEntity.ok(list);
    }

}
