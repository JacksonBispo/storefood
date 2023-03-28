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
import tech.webfoods.foodStore.service.CustomerService;
import tech.webfoods.foodStore.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PersonResource {

    private final CustomerService customerService;
    private final EmployeeService employeeService;


    @PostMapping(value = "/customer/save")
    public ResponseEntity<PersonDTO> saveCustomer(@RequestBody @Valid SaveCustomerDTO customerDTO){
       var customer = customerService.save(customerDTO);
       return ResponseEntity.ok(CustomerConverter.toDTO(customer));
    }

    @PostMapping(value = "/employee/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody @Valid SaveEmployeeDTO saveEmployeeDTO){
        var employee = employeeService.save(saveEmployeeDTO);
        return ResponseEntity.ok(EmployeeConverter.toDTO(employee));
    }

    @GetMapping(value = "/customer/customers")
    public ResponseEntity<Page<CustomerDTO>> listCustomer(@PageableDefault(size = 10, sort = {"name"})Pageable pageable){
        var list  = customerService.getAllPersons(pageable).map(CustomerConverter::toDTO);
        return ResponseEntity.ok(list);
    }

}
