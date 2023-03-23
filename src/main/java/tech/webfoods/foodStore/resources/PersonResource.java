package tech.webfoods.foodStore.resources;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.EmployeeDTO;
import tech.webfoods.foodStore.dto.PersonDTO;
import tech.webfoods.foodStore.dto.SaveCustomerDTO;
import tech.webfoods.foodStore.dto.SaveEmployeeDTO;
import tech.webfoods.foodStore.repository.DistrictRepository;
import tech.webfoods.foodStore.service.CustomerService;
import tech.webfoods.foodStore.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PersonResource {

    private final CustomerService customerService;
    private final EmployeeService employeeService;

    private final DistrictRepository districtRepository;

    @PostMapping(value = "/customer/save")
    public ResponseEntity<PersonDTO> saveCustomer(@RequestBody SaveCustomerDTO customerDTO){
       var customer = customerService.save(customerDTO);
       return ResponseEntity.ok(CustomerConverter.toDTO(customer));
    }

    @PostMapping(value = "/employee/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody SaveEmployeeDTO saveEmployeeDTO){
        var employee = employeeService.save(saveEmployeeDTO);
        return ResponseEntity.ok(EmployeeConverter.toDTO(employee));
    }

}
